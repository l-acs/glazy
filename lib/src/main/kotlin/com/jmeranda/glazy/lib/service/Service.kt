package com.jmeranda.glazy.lib.service

import com.jmeranda.glazy.lib.exception.NotInRepo
import com.jmeranda.glazy.lib.objects.Repo

import java.io.File

import org.eclipse.jgit.errors.RepositoryNotFoundException
import org.eclipse.jgit.lib.Config
import org.eclipse.jgit.lib.StoredConfig
import org.eclipse.jgit.storage.file.FileBasedConfig
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import org.eclipse.jgit.util.FS
import java.lang.IllegalArgumentException

/**
 * Services will provide high level access to operations on a repository and its elements.
 *
 * @param user The username of the repository.
 * @param name The name of the repository.
 * @param token The access token to be used for authentication.
 */
abstract class Service(
    protected val user: String,
    protected val name: String,
    protected val token: String?)

/**
 * A list of all config files for git.
 */
private val config: StoredConfig by lazy {
    val cfg =  try {
        FileRepositoryBuilder()
            FileRepositoryBuilder()
            .setMustExist(true)
            .findGitDir().let { builder ->
                val fbcfg = FileBasedConfig(
                    builder.build().config,
                    File(builder.gitDir, "config"),
                    FS.detect())

                // finish config setup
                fbcfg.load()
                fbcfg
            }
    } catch (e: Exception) {
        // config of system and user config files
        FileBasedConfig(
            FileBasedConfig(File("/etc/gitconfig"), FS.detect()),
            File(System.getProperty("user.home"), ".gitconfig"),
            FS.detect()
        )
    }

    cfg.load()
    cfg
}

/**
 * Determine the token to use for authentication.
 *
 * @return The personal access token.
 */
fun getToken(): String? {
    return try {
        config.getString("github", null, "token")
    } catch (e: NotInRepo) {
        null
    }
}

/**
 * Determine the user to use for authentication.
 *
 * @return The username for authentication.
 */
@Throws(NotInRepo::class)
fun getUser(): String? {
    return try {
        config.getString("github", null, "user")
    } catch (e: NotInRepo) {
        null
    }
}

/**
 * Change local remotes and directory names to reflect a repository name change.
 *
 * @param patchedRepo A repository object representing the current state of the repository.
 */
@Throws(NotInRepo::class)
fun changeLocalName(patchedRepo: Repo) {
    // retrieve the old remote value
    // will also return on null config or value
    val remote = config.getString("remote", "origin", "url") ?: return

    // change the remote configuration to the new url
    config.setString("remote", "origin", "url",
        if (remote.contains("https")) {
            patchedRepo.cloneUrl
        } else {
            patchedRepo.sshUrl
        })

    // save the new configuration to persistent storage
    config.save()

    // rename the root directory
    val dir = File(System.getProperty("user.dir"))
    dir.renameTo(File(dir.parent + File.separator + patchedRepo.name))
}

/**
 * Determine the user login and name of the current repository.
 *
 * If no targetPath is given, getRepoName will attempt to parse the 'config' file located in the current repositories
 * '.git' directory. The
 *
 * @param targetPath The path of the file to parse the information from, will most often will most often be
 *      <some_path>/.git/config.
 * @return A [Pair] specifying the repository owner and name, or a [Pair] of nulls if an error occurs.
 * @throws NotInRepo When the target path is null and there is no provided target path to parse.
 */
@Throws(NotInRepo::class)
fun getRepoName(targetPath: String? = null): Pair<String?, String?> {
    val cfg: StoredConfig = (if (targetPath == null) {
        config
    } else {
        FileBasedConfig(File(targetPath), FS.detect())
    })

    cfg.load()

    val url = cfg.getString("remote", "origin", "url") ?: return Pair(null, null)

    return url.split(":").last()
        .split("/").let {
            Pair(it[it.lastIndex - 1],
                it[it.lastIndex].replace(".git", ""))
        }
}