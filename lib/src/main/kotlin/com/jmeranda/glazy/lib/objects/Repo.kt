package com.jmeranda.glazy.lib.objects

/**
 * Describes the permissions on a repository.
 */
data class Permissions(
        val admin: Boolean,
        val pull: Boolean,
        val push: Boolean
)

/**
 * Describes a github repository.
 */
data class Repo(
        override val id: Int,
        override val nodeId: String,
        val archiveUrl: String,
        val archived: Boolean,
        val assigneesUrl: String,
        val blobsUrl: String,
        val branchesUrl: String,
        val cloneUrl: String,
        val collaboratorsUrl: String,
        val commentsUrl: String,
        val commitsUrl: String,
        val compareUrl: String,
        val contentsUrl: String,
        val contributorsUrl: String,
        val createdAt: String,
        val defaultBranch: String,
        val deploymentsUrl: String,
        val description: String? = null,
        val disabled: Boolean,
        val downloadsUrl: String,
        val eventsUrl: String,
        val fork: Boolean,
        val forks: Int,
        val forksCount: Int,
        val forksUrl: String,
        val fullName: String,
        val gitCommitsUrl: String,
        val gitRefsUrl: String,
        val gitTagsUrl: String,
        val gitUrl: String,
        val hasDownloads: Boolean,
        val hasIssues: Boolean,
        val hasPages: Boolean,
        val hasProjects: Boolean,
        val hasWiki: Boolean,
        val homepage: String? = null,
        val hooksUrl: String,
        val htmlUrl: String,
        val issueCommentUrl: String,
        val issueEventsUrl: String,
        val issuesUrl: String,
        val keysUrl: String,
        val labelsUrl: String,
        val language: String? = null,
        val languagesUrl: String,
        val license: License? = null,
        val mergesUrl: String,
        val milestonesUrl: String,
        val mirrorUrl: String? = null,
        val name: String,
        val networkCount: Int,
        val notificationsUrl: String,
        val openIssues: Int,
        val openIssuesCount: Int,
        val organization: Organization? = null,
        val owner: User,
        val permissions: Permissions? = null,
        val `private`: Boolean,
        val pullsUrl: String,
        val pushedAt: String,
        val releasesUrl: String,
        val size: Int,
        val sshUrl: String,
        val stargazersCount: Int,
        val stargazersUrl: String,
        val statusesUrl: String,
        val subscribersCount: Int,
        val subscribersUrl: String,
        val subscriptionUrl: String,
        val svnUrl: String? = null,
        val tagsUrl: String,
        val teamsUrl: String,
        val tempCloneToken: String? = null,
        val treesUrl: String,
        val updatedAt: String,
        val url: String,
        val watchers: Int,
        val watchersCount: Int
) : GitObject(id, nodeId)
