package com.example.domain.model


data class Actions (

  var viewReports          : ViewReports?          = ViewReports(),
  var editReports          : EditReports?          = EditReports(),
  var viewGradeBookPage    : ViewGradeBookPage?    = ViewGradeBookPage(),
  var viewGradeBook        : ViewGradeBook?        = ViewGradeBook(),
  var editLti              : EditLti?              = EditLti(),
  var editAdvancedSettings : EditAdvancedSettings? = EditAdvancedSettings(),
  var managePermissions    : ManagePermissions?    = ManagePermissions(),
  var viewRevenue          : ViewRevenue?          = ViewRevenue(),
  var canBeBought          : CanBeBought?          = CanBeBought(),
  var canBePriceChanged    : CanBePriceChanged?    = CanBePriceChanged(),
  var canBeDeleted         : CanBeDeleted?         = CanBeDeleted(),
  var editTags             : EditTags?             = EditTags()

)