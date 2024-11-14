package com.example.data.model

import com.example.domain.model.Actions
import com.google.gson.annotations.SerializedName


data class ActionsDto(

    @SerializedName("view_reports") var viewReports: ViewReportsDto? = ViewReportsDto(),
    @SerializedName("edit_reports") var editReports: EditReportsDto? = EditReportsDto(),
    @SerializedName("view_grade_book_page") var viewGradeBookPage: ViewGradeBookPageDto? = ViewGradeBookPageDto(),
    @SerializedName("view_grade_book") var viewGradeBook: ViewGradeBookDto? = ViewGradeBookDto(),
    @SerializedName("edit_lti") var editLti: EditLtiDto? = EditLtiDto(),
    @SerializedName("edit_advanced_settings") var editAdvancedSettings: EditAdvancedSettingsDto? = EditAdvancedSettingsDto(),
    @SerializedName("manage_permissions") var managePermissions: ManagePermissionsDto? = ManagePermissionsDto(),
    @SerializedName("view_revenue") var viewRevenue: ViewRevenueDto? = ViewRevenueDto(),
    @SerializedName("can_be_bought") var canBeBought: CanBeBoughtDto? = CanBeBoughtDto(),
    @SerializedName("can_be_price_changed") var canBePriceChanged: CanBePriceChangedDto? = CanBePriceChangedDto(),
    @SerializedName("can_be_deleted") var canBeDeleted: CanBeDeletedDto? = CanBeDeletedDto(),
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