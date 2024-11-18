package com.example.data.remote.model


import com.example.domain.model.Actions
import com.google.gson.annotations.SerializedName

data class ActionsDto(
    @SerializedName("view_reports") var viewReports: com.example.data.remote.model.ViewReportsDto? = com.example.data.remote.model.ViewReportsDto(),
    @SerializedName("edit_reports") var editReports: com.example.data.remote.model.EditReportsDto? = com.example.data.remote.model.EditReportsDto(),
    @SerializedName("view_grade_book_page") var viewGradeBookPage: ViewGradeBookPageDto? = ViewGradeBookPageDto(),
    @SerializedName("view_grade_book") var viewGradeBook: com.example.data.remote.model.ViewGradeBookDto? = com.example.data.remote.model.ViewGradeBookDto(),
    @SerializedName("edit_lti") var editLti: com.example.data.remote.model.EditLtiDto? = com.example.data.remote.model.EditLtiDto(),
    @SerializedName("edit_advanced_settings") var editAdvancedSettings: EditAdvancedSettingsDto? = EditAdvancedSettingsDto(),
    @SerializedName("manage_permissions") var managePermissions: ManagePermissionsDto? = ManagePermissionsDto(),
    @SerializedName("view_revenue") var viewRevenue: ViewRevenueDto? = ViewRevenueDto(),
    @SerializedName("can_be_bought") var canBeBought: com.example.data.remote.model.CanBeBoughtDto? = com.example.data.remote.model.CanBeBoughtDto(),
    @SerializedName("can_be_price_changed") var canBePriceChanged: CanBePriceChangedDto? = CanBePriceChangedDto(),
    @SerializedName("can_be_deleted") var canBeDeleted: com.example.data.remote.model.CanBeDeletedDto? = com.example.data.remote.model.CanBeDeletedDto(),
    @SerializedName("edit_tags") var editTags: EditTagsDto? = EditTagsDto()

) {
    fun mapDomain() = Actions(
        viewReports?.mapDomain(),
        editReports?.mapDomain(),
        viewGradeBookPage?.mapDomain(),
        viewGradeBook?.mapDomain(),
        editLti?.mapDomain(),
        editAdvancedSettings?.mapDomain(),
        managePermissions?.mapDomain(),
        viewRevenue?.mapDomain(),
        canBeBought?.mapDomain(),
        canBePriceChanged?.mapDomain(),
        canBeDeleted?.mapDomain(),
        editTags?.mapDomain()
    )
}