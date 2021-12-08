> reg 字符串 = 模式匹配的模式串

##### reg := 模式 + [修饰符:g/i/m/u/y ~ 鸡唛]

- 修饰符
  - i：不区分大小写；
- 
  如果不使用我们在后面将要学到的修饰符和特殊标志，正则表达式的搜索就等同于**子字符串查找**。
- `str.search(regexp)` 方法返回的是找到的**匹配项的索引位置**，如果没找到则返回 `-1`。

##### reg := 模式 [+ 修饰符] + 特殊标记

- 模式（字符类）：character-classes

  | 字符类           | 含义                                                         | 备注  |
  | ---------------- | ------------------------------------------------------------ | ----- |
  | /d，数字         | 从 `0` 到 `9` 的字符                                         | digit |
  | /s，空格或\n\t等 | 包括空格，制表符 `\t`，换行符 `\n` 和其他少数稀有字符，例如 `\v`，`\f` 和 `\r` | space |
  | /w，单字字符     | 拉丁字母或数字或下划线 `_`。非拉丁字母（如西里尔字母或印地文）不属于 `\w` | word  |

  - 字符类的**反向类**：用大写字母表示的字符类，用于匹配除对应小写字母所匹配的字符之外的所有字符；

    ```js
    let str = "+7(903)-123-45-67";
    alert( str.match(/\d/g).join('') ); // 79031234567
    alert( str.replace(/\D/g, "") ); // 79031234567
    ```

  - '点'：特殊的字符类，用于匹配“**除换行符之外**的任何单个字符”；

    ```js
    alert( "Z".match(/./) ); // Z
    
    let regexp = /CS.4/;
    alert( "CSS4".match(regexp) ); // CSS4
    alert( "CS-4".match(regexp) ); // CS-4
    alert( "CS 4".match(regexp) ); // CS 4 (space is also a character)
    ```

  - **特殊标记** 's' ：用于使'点'字符类匹配任何单个字符，包括换行符\n；

    ```js
    alert( "A\nB".match(/A.B/) ); // null (no match)
    alert( "A\nB".match(/A.B/s) ); // A\nB (match!)
    // [\s\S]/[\d\D]... 有相同作用，或者使用 [^] 意思是匹配任何字符，除了什么都没有；
    alert( "A\nB".match(/A[\s\S]B/) ); // A\nB (match!)
    ```

- 修饰符（unicode）：u
  js 由于[历史局限性](https://zh.javascript.info/regexp-unicode#unicode-shu-xing-unicodepropertiesp)会把一个 4 个字节的“长字符”当成一对 2 个字节长的字符；

  当一个正则表达式使用**修饰符u**后，4 个字节长的字符将被正确地处理；

  - 

