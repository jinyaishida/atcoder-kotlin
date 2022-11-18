### 問題13

Triple-quoted strings are not only useful for multiline strings but also for creating regex patterns as you don't need to escape a backslash with a backslash.
The following pattern matches a date in the format 13.06.1992 (two digits, a dot, two digits, a dot, four digits):
    
    fun getPattern() = """\d{2}\.\d{2}\.\d{4}"""

Using the month variable, rewrite this pattern in such a way that it matches the date in the format 13 JUN 1992 (two digits, one whitespace, a month abbreviation, one whitespace, four digits).

---
解答

    val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
    
    fun getPattern(): String = """\d{2}\ $month \d{4}"""

---
知識

エスケープを含まない文字列のことを生文字列(raw string)と呼び、
生文字列はトリプルクォート(“””)で括って書くことができ、
エスケープを含まずに改行やその他の文字を表すことができる。

    """Teamlab"""

また、kotlinの新しいテンプレート機能を使うと"""で正規表現を括ることもできるようになった。
Javaにはなかったテンプレート機能で 文字列の結合や変数をいれるときに+で結合やStringBuilderなどを使う必要がなくなった。

    """\d{2}\ $変数名 \d{4}"""
だけでOK

テンプレートを使わない場合は、

    "\\d{2} ${変数名} \\d{4}"

または、

    "\\d{2} " + 変数名 + " \\d{4}"


