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
fun getWhatisAnnotated(): AnnotatedString {
    return buildAnnotatedString {
        val text="What is: https://breeds.tipolisto.es/index/Home/whatis"
        append(text)
        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary
            ), start = 5, end = text.length
        )
        addStringAnnotation(
            tag = "What is",
            annotation = "https://breeds.tipolisto.es/index/Home/whatis",
            start = 5,
            end = text.length
        )
    }
}
@Composable
fun getTermsAnnotated(): AnnotatedString {
    return buildAnnotatedString {
        val text="Terms: https://breeds.tipolisto.es/index/Home/license"
        append(text)
        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary
            ), start = 6, end = text.length
        )
        addStringAnnotation(
            tag = "Terms",
            annotation = "https://breeds.tipolisto.es/index/Home/license",
            start = 6,
            end = text.length
        )
    }
}

@Composable
fun getContactAnnotated(): AnnotatedString {
    return buildAnnotatedString {
        val text="Contact: https://breeds.tipolisto.es/index/Home/about"
        append(text)
        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary
            ), start = 8, end = text.length
        )
        addStringAnnotation(
            tag = "Contact",
            annotation = "https://breeds.tipolisto.es/index/Home/about",
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
            tag = "Register",
            annotation = "https://breeds.tipolisto.es/index/Auth/register",
            start = 9,
            end = text.length
        )
    }
}
@Composable
fun getRateBeautiesAnnotated(): AnnotatedString {
    return buildAnnotatedString {
        val text="Beauties: https://breeds.tipolisto.es/index/Home/beauties"
        append(text)
        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            ), start = 17, end = text.length
        )
        addStringAnnotation(
            tag = "Beauties",
            annotation = "https://breeds.tipolisto.es/index/Home/beauties",
            start = 17,
            end = text.length
        )
    }
}
@Composable
fun getMyNaimalsAnnotated(): AnnotatedString {
    return buildAnnotatedString {
        val text="My animals: https://breeds.tipolisto.es/index/User/showAll"
        append(text)
        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            ), start = 12, end = text.length
        )
        addStringAnnotation(
            tag = "My animals",
            annotation = "https://breeds.tipolisto.es/index/User/showAll",
            start = 12,
            end = text.length
        )
    }
}
@Composable
fun getRecordsAnnotated(): AnnotatedString {
    return buildAnnotatedString {
        val text="Records: https://breeds.tipolisto.es/index/Score/showAll"
        append(text)
        addStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            ), start = 9, end = text.length
        )
        addStringAnnotation(
            tag = "Records",
            annotation = "https://breeds.tipolisto.es/index/Score/showAll",
            start = 9,
            end = text.length
        )
    }
}

