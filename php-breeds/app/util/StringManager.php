<?php
class StringManager {
    public static function getLastWordFromPath($path){
        if ($path==null || empty($path)) return "";
        $lengh=strlen($path);
        //Encuentra la posición númerica de la última aparición de needle (aguja) en el string haystack (pajar).
        //strrpos(string $haystack, mixed $needle, int $offset = 0): int
        $lastSlashPosition=strrpos($path, "/");
        //Devuelve una parte del string definida por los parámetros start y length.
        //substr(string $string, int $start, int $length = ?): string
        //https://www.php.net/manual/es/function.substr
        $substring=substr($path, $lastSlashPosition+1, $lengh);
        return $substring;
    }
    public static function cutString($cadena, $length){
        //Strip_tags: retira las etiquetas HTML y PHP de un String
        //substr($cadena, corta inicio, corta final)
        //strlen: devuelve la longitud de la cadena
        $stringDisplay = substr(strip_tags($cadena), 0, $length);
        if (strlen(strip_tags($cadena)) > $length)
            $stringDisplay .= ' ...';
        return $stringDisplay;
    }
    public static function formatText($name) {
        //$except = array('\\', '/', ':', '*', '?', '"', '<', '>', '|', '\'', '{', '}', " ", "-");
        $except = array('\\', '/', ':', '*', '?', '"', '\'', '<', '>', '|', '\'', '{', '}');
        //$except = array( '"', '\'');
        //Le quitamos los espacios
        //$except = str_replace(" ","-",$except);
        return str_replace($except, '', $name);
    }
}