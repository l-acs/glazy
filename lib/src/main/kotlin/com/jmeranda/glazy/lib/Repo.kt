package com.jmeranda.glazy.lib

/**
 * Describes the owner of a repository.
 */
data class Owner (
        val login: String,
        val id: Int,
        val nodeId: String,
        val avatarUrl: String,
        val gravatarId: String? = null,
        val url: String,
        val htmlUrl: String,
        val followersUrl: String,
        val followingUrl: String,
        val gistsUrl: String,
        val starredUrl: String,
        val subscriptionsUrl: String,
        val organizationsUrl: String,
        val reposUrl: String,
        val eventsUrl: String,
        val receivedEventsUrl: String,
        val type: String,
        val siteAdmin: Boolean
)

/**
 * Describes a license (MIT, GPL, etc).
 */
data class License(
        val key: String,
        val name: String,
        val spdxId: String? = null,
        val url: String? = null,
        val nodeId: String? = null
)

/**
 * Describes the permissions on a repository.
 */
data class Permissions(
        val admin: Boolean,
        val push: Boolean,
        val pull: Boolean
)

/**
 * Describes a github repository.
 */
data class Repo(
        val id: Int,
        val nodeId: String,
        val name: String,
        val fullName: String,
        val private: Boolean,
        val owner: Owner,
        val htmlUrl: String,
        val description: String? = null,
        val fork: Boolean,
        val url: String,
        val forksUrl: String,
        val keysUrl: String,
        val collaboratorsUrl: String,
        val teamsUrl: String,
        val hooksUrl: String,
        val issueEventsUrl: String,
        val eventsUrl: String,
        val assigneesUrl: String,
        val branchesUrl: String,
        val tagsUrl: String,
        val blobsUrl: String,
        val gitTagsUrl: String,
        val gitRefsUrl: String,
        val treesUrl: String,
        val statusesUrl: String,
        val languagesUrl: String,
        val stargazersUrl: String,
        val contributorsUrl: String,
        val subscribersUrl: String,
        val subscriptionUrl: String,
        val commitsUrl: String,
        val gitCommitsUrl: String,
        val commentsUrl: String,
        val issueCommentUrl: String,
        val contentsUrl: String,
        val compareUrl: String,
        val mergesUrl: String,
        val archiveUrl: String,
        val downloadsUrl: String,
        val issuesUrl: String,
        val pullsUrl: String,
        val milestonesUrl: String,
        val notificationsUrl: String,
        val labelsUrl: String,
        val releasesUrl: String,
        val deploymentsUrl: String,
        val createdAt: String,
        val updatedAt: String,
        val pushedAt: String,
        val permissions: Permissions? = null,
        val gitUrl: String,
        val sshUrl: String,
        val cloneUrl: String,
        val svnUrl: String? = null,
        val homepage: String? = null,
        val size: Int,
        val stargazersCount: Int,
        val watchersCount: Int,
        val language: String? = null,
        val hasIssues: Boolean,
        val hasProjects: Boolean,
        val hasDownloads: Boolean,
        val hasWiki: Boolean,
        val hasPages: Boolean,
        val forksCount: Int,
        val mirrorUrl: String? = null,
        val archived: Boolean,
        val disabled: Boolean,
        val openIssuesCount: Int,
        val license: License? = null,
        val forks: Int,
        val openIssues: Int,
        val watchers: Int,
        val defaultBranch: String,
        val networkCount: Int,
        val subscribersCount: Int,
        val allowSquashMerge: Boolean,
        val allowMergeCommit: Boolean,
        val allowRebaseMerge: Boolean
)