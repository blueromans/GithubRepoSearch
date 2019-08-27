package com.mizmer.github.search
import kotlin.collections.ArrayList

data class Item(
    val id: Long?,
    val name: String?,
    val full_name: String?,
    val owner: Owner,
    val private: Boolean,
    val html_url: String?,
    val description: String?
)
data class RepoList (val total_count: Int, val incomplete_results: Boolean, val items: ArrayList<Item>)
data class Owner(val login: String?, val id: Long?, val avatar_url: String?)