package com.hazael.navigationcomponentsexample

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * @author Yaniv Zolicha
 */
@Parcelize
data class Money(
val amount : BigDecimal
) : Parcelable