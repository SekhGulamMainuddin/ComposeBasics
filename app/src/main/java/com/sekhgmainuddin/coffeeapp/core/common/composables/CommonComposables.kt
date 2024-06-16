package com.sekhgmainuddin.coffeeapp.core.common.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sekhgmainuddin.coffeeapp.core.common.AppTextM12
import com.sekhgmainuddin.coffeeapp.core.common.AppTextStyles
import com.sekhgmainuddin.coffeeapp.core.theme.AppColors

@Preview
@Composable
fun PriceComposable(
    modifier: Modifier = Modifier,
    price: String = "4.99",
    textStyle: TextStyle = AppTextStyles.S16,
    currencyColor: Color? = null
) {
    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            pushStyle(
                textStyle.copy(color = currencyColor ?: AppColors.SecondaryThemedColor)
                    .toSpanStyle()
            )
            append("$")
            pop()
            append(" $price")
        },
        style = textStyle,
    )
}

@Composable
fun PriceAndPayComposable(
    modifier: Modifier = Modifier,
    totalAmount: String,
    payButtonText: String,
    onPayClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 25.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppTextM12(
                text = "Price",
                color = AppColors.ThemedLightGrey
            )
            PriceComposable(
                price = totalAmount,
                textStyle = AppTextStyles.S20,
            )
        }
        PrimaryButton(
            modifier = Modifier.weight(1f),
            text = payButtonText,
            onClick = onPayClick
        )
    }
}