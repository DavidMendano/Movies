package com.dmendano.feature_home.mappers

import com.dmendano.common.model.MovieItemUiModel
import com.dmendano.domain.models.MovieUiModel

fun MovieUiModel.toItemModel(): MovieItemUiModel =
    MovieItemUiModel(id, urlImage, title, favourite)