package com.robbyp.reactive.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import java.util.*

data class FixedDepositDetails(@Id val fixedDepositId: ObjectId = ObjectId.get(),
                               val fdCreationDate: Date,
                               val fdAmount: Int,
                               val tenure: Int,
                               val active: String)
