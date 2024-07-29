package es.tipolisto.breeds.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString

@Composable
fun getWebAnnotated(): AnnotatedString {
    return buildAnnotatedString {
        val text="Web: https://breeds.tipolisto.es"
        append(text)
        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary
            ), start = 5, end = text.length
        )
        addStringAnnotation(
            tag = "web",
            annotation = "https://breeds.tipolisto.es",
            start = 5,
            end = text.length
        )
    }
}
@Composable
fun getTermsAnnotated(): AnnotatedString {
    return buildAnnotatedString {
        val text="Terms: https://google.com/terms"
        append(text)
        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary
            ), start = 6, end = text.length
        )
        addStringAnnotation(
            tag = "terms",
            annotation = "https://google.com/terms",
            start = 6,
            end = text.length
        )
    }
}

@Composable
fun getContactAnnotated(): AnnotatedString {
    return buildAnnotatedString {
        val text="Contact: email://adm.tipolisto.es"
        append(text)
        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary
            ), start = 8, end = text.length
        )
        addStringAnnotation(
            tag = "contact",
            annotation = "email://adm.tipolisto.es",
            start = 8,
            end = text.length
        )
    }
}
@Composable
fun getRegisterAnnotated(): AnnotatedString {
    return buildAnnotatedString {
        val text="Register: https://breeds.tipolisto.es/index/Auth/register"
        append(text)
        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary
            ), start = 9, end = text.length
        )
        addStringAnnotation(
            tag = "register",
            annotation = "https://breeds.tipolisto.es/index/Auth/register",
            start = 9,
            end = text.length
        )
    }
}
@Composable
fun getRateBeautiesAnnotated(): AnnotatedString {
    return buildAnnotatedString {
        val text="Puntuar: https://breeds.tipolisto.es/index/Beauties/showRandom"
        append(text)
        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary
            ), start = 8, end = text.length
        )
        addStringAnnotation(
            tag = "Puntuar",
            annotation = "https://breeds.tipolisto.es/index/Beauties/showRandom",
            start = 8,
            end = text.length
        )
    }
}
