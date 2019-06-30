package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils

fun User.toUserView():UserView {
    val nickName = Utils.translitaration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) "Ни разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit.humanizedDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        initials = initials,
        avatar = avatar,
        status = status
    )
}