> reg 字符串 = 模式匹配的模式串；
>
> Patterns 模式，flags 修饰符，Anchors 锚点;
>
> 有的地方把 flags 翻译为修饰符，有的地方翻译为标志，s则翻译为特殊标志，在这里统一为修饰符与特殊修饰符；
>
> ------
>
> 采用以下书写格式
>
> - 标题，注释.....
>   用于.....
>
>   ```js
>   实例代码
>   ```

#### 1. / Patterns / [ flags: [g i m u y]() ~ 鸡唛 ]

- 常用修饰符 (flags) 不包括特殊修饰符
  i：不区分大小写；
  u：开启完整的 unicode 支持；
  g：搜索时会查找所有的匹配项，而不只是第一个；
  m：多行模式；y：粘滞模式；
- 
  如果不使用修饰符和特殊修饰符，正则表达式的搜索就等同于子字符串查找。
- `str.search(regexp)` 方法返回的是找到的匹配项的索引位置，如果没找到则返回 `-1`。
  str.match(/regexp/) 方法返回的是查找到的子字符串。
  /regexp/.test("...") 方法返回的是Boolean；

#### 2. / Patterns: [\d \s \w \D \S \W .]() / [ flags: [s]() ]

- **Character classes**

  模式串中的字符类

  | 字符类           | 含义                                                         | 备注  |
  | ---------------- | ------------------------------------------------------------ | ----- |
  | \d，数字         | 从 `0` 到 `9` 的字符                                         | digit |
  | \s，空格或\n\t等 | 包括空格，制表符 `\t`，换行符 `\n` 和其他少数稀有字符，例如 `\v`，`\f` 和 `\r` | space |
  | \w，单字字符     | 拉丁字母或数字或下划线 `_`。非拉丁字母（如西里尔字母或印地文）不属于 `\w` | word  |

- **字符类的反向类**，形式上是用大写字母表示的字符类；
  用于匹配除对应小写字母所匹配的字符之外的所有字符；

  ```js
  let str = "+7(903)-123-45-67";
  alert( str.match(/\d/g).join('') ); // 79031234567
  alert( str.replace(/\D/g, "") ); // 79031234567
  ```

- **特殊字符类 Dot**
  用于匹配 “除换行符之外的任何单个字符”；

  ```js
  alert( "Z".match(/./) ); // Z
  
  let regexp = /CS.4/;
  alert( "CSS4".match(regexp) ); // CSS4
  alert( "CS-4".match(regexp) ); // CS-4
  alert( "CS 4".match(regexp) ); // CS 4 (space is also a character)
  ```

- **特殊修饰符 s**
  用于使特殊字符类 Dot 的匹配包括换行符\n，既匹配任何单个字符；

  ```js
  alert( "A\nB".match(/A.B/) ); // null (no match)
  alert( "A\nB".match(/A.B/s) ); // A\nB (match!)
  // [\s\S]/[\d\D]... 有相同作用，或者使用 [^] 意思是匹配任何字符，除了什么都没有；
  alert( "A\nB".match(/A[\s\S]B/) ); // A\nB (match!)
  ```


#### 3. / Patterns: [\p{...}]() / [ flags: [u]() ]

- **u**，既Unicode首字母；

  js 由于[历史局限性](https://zh.javascript.info/regexp-unicode#unicode-shu-xing-unicodepropertiesp)会把一个 4 个字节的“长字符”当成一对 2 个字节长的字符；

  当一个正则表达式使用**修饰符u**后，4 个字节长的字符将被正确地处理：被看成单个的字符，而不是 2 个 2 字节长的字符；

- Unicode 属性
  Unicode 中的每一个字符都具有很多的属性。它们描述了一个字符属于哪个“类别”，包含了各种关于字符的信息。

  例如，如果一个字符具有 `Letter` 属性，这意味着这个字符归属于（任意语言的）一个字母表。而 `Number` 属性则表示这是一个数字：也许是阿拉伯语，亦或者是中文，等等。

- **/ \p{L} /gu**，查找字母(所有语言的)
  L 是 Letter(字母) 的缩写，Unicode属性们几乎都有缩写；
  为了使用**\p{...}**必须使用**修饰符u**；

  ```js
  let str = "A ბ ㄱ";
  
  alert( str.match(/\p{L}/gu) ); // A,ბ,ㄱ
  alert( str.match(/\p{L}/g) ); // null（没有匹配的文本，因为没有修饰符“u”）
  ```

- **\p{Hex_Digit}**，查找16进制数字

  查找 16 进制数字，写作 **xFF** 其中 `F` 是一个 16 进制的数字（0…9 或者 A…F）。

  一个 16 进制数字可以表示为 **\p{Hex_Digit}**：

  ```js
  let regexp = /x\p{Hex_Digit}\p{Hex_Digit}/u;
  alert("number: xAF".match(regexp)); // xAF
  ```

- **\p{sc=Han}**，查找中文字符

  unicode 属性 `Script` （书写系统），这个属性可以有一个值：`Cyrillic`，`Greek`，`Arabic`，`Han` （中文）等等，[这里是一个完整的列表](https://en.wikipedia.org/wiki/Script_(Unicode))。

  为了实现查找一个给定的书写系统中的字符，我们需要使用 `Script=<value>`，例如对于中文字符：**\p{sc=Han}**。

  ```js
  let regexp = /\p{sc=Han}/gu; // returns Chinese hieroglyphs（象形文字）
  let str = `Hello Привет 你好 123_456`;
  alert( str.match(regexp) ); // 你,好
  ```

- **\p{Sc}**，查找货币符号
  表示货币的字符，例如 `$`，`€`，`¥`，具有 unicode 属性 **\p{Currency_Symbol}**，缩写为 **\p{Sc}**；

  ```js
  let regexp = /\p{Sc}\d/gu;
  let  str = `Prices: $2, €1, ¥9`;
  alert( str.match(regexp) ); // $2,€1,¥9
  ```

#### 4. / Anchors: [^ $]() / [ flags: [m]() ]

- **^ $** 单独用

```js
let str1 = "Mary had a little lamb";
alert( /^Mary/.test(str1) ); // true

let str1 = "it's fleece was white as snow";
alert( /snow$/.test(str1) ); // true
```

- **^ $** 组合用

```
let goodInput = "12:34";
let badInput = "12:345";

let regexp = /^\d\d:\d\d$/;
alert( regexp.test(goodInput) ); // true
alert( regexp.test(badInput) ); // false
```

- 什么字符串可以匹配模式 `^$`？唯一一个匹配的字符串是空字符串：它的开始紧跟着结束

- **修饰符 m**
  开启锚点匹配的多行模式，仅仅影响 **^ $** 的行为

  ```js
  let str = `1st place: Winnie
  2nd place: Piglet
  33rd place: Eeyore`;
  
  str.match(/^\d/m); // ['1']
  str.match(/^\d/mg); // (3) ['1', '2', '3']
  str.match(/^\d+/mg); // (3) ['1', '2', '33']
  
  str.match(/\w$/m); // ['e']
  str.match(/\w$/mg); // (3) ['e', 't', 'e']
  str.match(/\w+$/mg); // (3) ['Winnie', 'Piglet', 'Eeyore']
  ```

- TODO : ^$ 与 \n 匹配一行 balabala

#### 5. 词边界 [\b]()

   何处有边界？单词前后，数字前后；
   借助 `/\bHello\b/` 理解边界：词边界测试 `\b` 检查位置的一侧是否匹配 `\w`，而另一侧则不匹配 “`\w`”。但是，`\w` 表示拉丁字母 `a-z`（或数字或下划线），因此此检查不适用于其他字符，如西里尔字母（cyrillic letters）或象形文字（hieroglyphs）。

   ```js
   let foo = "_ : ! 中文 A 123 123"; // 数字,字母,下划线 的附近有边界 
   foo.match(/\b\s\b/g); // (2) [' ', ' '] ，如图黄色边界所示，这两个空格是"A空格123空格123"中的；
   ```

   ![image-20211209184149647](.image/image-20211209184149647.png)

#### 6. 集合 [[]]()

   ```js
   // 查找 [t 或者 m]，然后再匹配 “op”
   alert( "Mop top".match(/[tm]op/gi) ); // "Mop", "top"
   ```

   - 可以使用Unicode属性编写集合

   - 集合中的转义
     除了在方括号中有特殊含义的字符外，其它所有特殊字符都是允许不添加反斜杠的，当然转义也行。

     ```js
     // 并不需要转义
     let reg = /[-().^+]/g;
     
     alert( "1 + 2 - 3".match(reg) ); // 匹配 +，-
     ```

#### 7. 范围 [[foo-bar...]]()

   **[0-9]** —— 和 `\d` 相同，

   **[a-zA-Z0-9_]** —— 和 `\w` 相同，

   **[\t\n\v\f\r ]外加少量罕见的 unicode 空格字符** —— 和 `\s` 相同。

   - 自定义 \w
     字符类 `\w` 是简写的 `[a-zA-Z0-9_]`，因此无法找到中文象形文字，这很容易想到 Unicode 属性，可以编写一个更通用的模式，该模式可以查找任何语言中的文字字符。

     ```js
     let regexp = /[\p{Alpha}\p{M}\p{Nd}\p{Pc}\p{Join_C}]/gu;
     /*
     	Alphabetic (Alpha) —— 字母，
     	Mark (M) —— 重读，
     	Decimal_Number (Nd) —— 数字，
     	Connector_Punctuation (Pc) —— 下划线 '_' 和类似的字符，
     	Join_Control (Join_C) —— 两个特殊代码 200c and 200d，用于连字，例如阿拉伯语。
     */
     let str = `Hi 你好 12`;
     // finds all letters and digits:
     alert( str.match(regexp) ); // H,i,你,好,1,2
     ```

   - 排除范围 [`[^…]`]() 

     `[^0-9]` —— 匹配任何除了数字之外的字符，也可以使用 `\D` 来表示。
     `[^\s]` —— 匹配任何非空字符，也可以使用 `\S` 来表示


#### 8. 代理对(surrogate pairs)问题

https://zh.javascript.info/regexp-character-sets-and-ranges#fan-wei-he-biao-zhi-u
https://xinyuehtx.github.io/post/Unicode%E4%BB%A3%E7%90%86%E5%AF%B9.html
如果集合或范围中有代理对（surrogate pairs），则需要标志 `u` 以使其正常工作。

```js
alert( '𝒳'.match(/[𝒳𝒴]/) ); // 显示一个奇怪的字符，像 [?]
// 不加 /u（搜索执行不正确，返回了半个字符）
for(let i=0; i<'𝒳𝒴'.length; i++) {
    alert('𝒳𝒴'.charCodeAt(i)); // 55349, 56499, 55349, 56500
};
// 如上所示正则表达式引擎认为 [𝒳𝒴] 不是两个，而是四个字符，因此第二行的[?]就是55349
alert( '𝒳'.match(/[𝒳𝒴]/u) ); // 𝒳
// 加了/u ，结果正确。
'𝒳'.match(/[𝒳-𝒴]/); // 使用范围时=》错误：无效的正则表达式
// [𝒳-𝒴] 被解释为 [<55349><56499>-<55349><56500>]（每个代理对都替换为其代码）。现在很容易看出范围 56499-55349 是无效的：其起始代码 56499 大于终止代码 55349，其想要匹配“大-小”中的一个字符，这就是错误的原因。
alert( '𝒴'.match(/[𝒳-𝒵]/u) ); // 𝒴
// 加了/u,结果正确。查找字符从 𝒳 到 𝒵
```

#### 9. 量词 [+,*,?]() 和 [{n}]()

在一个字符（或一个字符类等等）后跟着量词，用来指出我们具体需要的数量。

- **{n}**

  `\d{5}` 表示 5 位的数字，如同 `\d\d\d\d\d`，它会查找一个五位数的数字。

- **{i,j}**
  查找位数为 3 至 5 位的数字：`\d{3,5}`。

- **\d{3,}**
  查找位数大于或等于 3 的数字。

- `+7(903)-123-45-67`，找到它包含的所有数字

  ```js
  let str = "+7(903)-123-45-67";
  
  let numbers = str.match(/\d{1,}/g);
  
  alert(numbers); // 7,903,123,45,67
  ```

- **{1,}  === +**

  ```js
  let str = "+7(903)-123-45-67";
  alert( str.match(/\d+/g) ); // 7,903,123,45,67
  ```

- **{0,1} === ?**

  ```js
  let str = "Should I write color or colour?";
  alert( str.match(/colou?r/g) ); // color, colour
  ```

- **{0,} === ***

  ```js
  alert( "100 10 1".match(/\d0*/g) ); // 100, 10, 1
  ```

- **\d+\.\d+**
  查找“浮点数”（带浮点的数字）

  ```js
  alert( "0 1 12.345 7890".match(/\d+\.\d+/g) ); // 12.345
  ```

- **/<[a-z]+>/i**
  查找“没有属性的 HTML 标记”，比如 `<span>` 或 `<p>`
  
  ```js
  alert( "<body> ... </body>".match(/<[a-z]+>/gi) ); // <body>
  ```
  
- **/<\[a-z][a-z0-9]\*>/i** ，**/<\/?\[a-z][a-z0-9]\*>/i**

  改进版

  ```js
  alert( "<h1>Hi!</h1>".match(/<[a-z][a-z0-9]*>/gi) ); // <h1>
  alert( "<h1>Hi!</h1>".match(/<\/?[a-z][a-z0-9]*>/gi) ); // <h1>, </h1>
  ```

-------

#### 10. 贪婪量词和惰性量词

\d+?空格：不是问号后边的，就重复匹配问号前边的，一次又一次。

> "123 456".match(/\d+? \d+?/g) // 123 4
> 这个例子中，模式串中后一个\d+?，只会匹配到4； 

.+"：一下干到底，然后回溯找冒号。

- 贪婪模式
  需求：找出所有被引号围起来的子串

  ```js
  let reg = /".+"/g;
  
  let str = 'a "witch" and her "broom" is one';
  
  alert( str.match(reg) ); // "witch" and her "broom"
  ```

  它直接找到了一个匹配结果：`"witch" and her "broom"`，而不是找到两个匹配结果 `"witch"` 和 `"broom"`。
  结论：“**贪婪**是万恶之源”

- 默认的贪婪模式的执行过程
  重点：当不可能检测更多（没有更多的字符或到达字符串末尾）时，再匹配模式的剩余部分。如果剩余部分匹配失败，则回溯，并再次尝试匹配剩余部分。

  - 尝试匹配模式串的第一个字符："
    用"去匹配str中的字符，若不匹配则往后移动，最终在第三个位置匹配成功；

    ```js
      ↓
      "
    a "witch" and her "broom" is one
    ```

  - 尝试匹配模式串中剩余的：.+"
    (.) 匹配除了换行符之外的任意字符，因为量词 + ，所以只有在移至字符串末尾时才停止匹配；

    ```js
                                   ↓
      ".............................
    a "witch" and her "broom" is one
    ```

  - .+ 的匹配结束，尝试匹配 "
    问题是，对字符串的遍历已经结束，已经没有更多的字符了！
    正则表达式引擎明白它已经为 `.+` 匹配了太多项了，所以开始**回溯**了。
    逐字符回溯匹配"，最终在最后一个引号的位置匹配成功。

    ```js
                            ↓
      "....................."
    a "witch" and her "broom" is one
    ```

  - 故，第一次匹配是 `"witch" and her "broom"`，接下来的搜索的起点位于第一次搜索的终点，但在 `is one` 中没有更多的引号了，所以没有其它的结果了。

    **在贪婪模式下（默认情况下），量词都会尽可能地重复多次。**

    正则表达式引擎尝试用 `.+` 去获取尽可能多的字符，然后再一步步地筛选它们。

- 懒惰模式

  - 重点：它强调“重复最少次数”，在每次重复量词之前，引擎会尝试去匹配模式的剩余部分。通过在量词之后添加一个问号 `'?'` 来启用。

    ```js
    let reg = /".+?"/g;
    
    let str = 'a "witch" and her "broom" is one';
    
    alert( str.match(reg) ); // witch, broom
    ```

- 懒惰模式的执行步骤

  - 尝试匹配 "
    这一步跟贪婪一样；

    ```js
      ↓
      "
    a "witch" and her "broom" is one
    ```

  - 尝试匹配 .+?
    搜索过程出现不同了。因为我们对 `.+` 启用了懒惰模式，引擎不会去尝试多匹配一个点，并且开始了对剩余的 `"`的匹配；

    ```js
        ↓
      "."
    a "witch" and her "broom" is one
    ```

  - 如果有一个引号，搜索就会停止，但是有一个 `'i'`，所以没有匹配到引号。
    接着，正则表达式引擎增加对点的重复搜索次数，并且再次尝试匹配";

    ```js
         ↓
      ".."
    a "witch" and her "broom" is one
    ```

  - 又失败了。然后重复搜索次数一次又一次的增加，知道匹配到";

    ```js
            ↓
      "....."
    a "witch" and her "broom" is one
    ```

  - 至此模式串匹配成功一次，接下来的搜索工作从当前匹配结束的那一项开始，就会再匹配成功一次；

    ```js
            ↓               ↓
      "....."         "....."
    a "witch" and her "broom" is one
    ```

  - 至此再也找不到"，匹配结束；
    注意：**只有在模式的剩余部分无法在给定位置匹配时，正则表达式引擎才会增加重复次数。既只有在witch"中无法匹配剩余部分模式串(")时才会重复从w开始增加匹配(.)的次数。**

- 有贪有懒

  ```js
  alert( "123 456".match(/\d+ \d+?/g) ); // 123 4
  ```

  1. 贪婪模式 `\d+` 尝试匹配尽可能多的数字，因此在它找到 `123` 时停止，因为下一个字符为空格;

  2. 匹配到一个空格。

  3. 懒惰模式 `\d+?`，它匹配一个数字 `4` 并且尝试去检测模式的剩余部分是否匹配。

     但是在 `\d+?` 之后没有其它的匹配项了。

     懒惰模式不会在不必要的情况下重复任何事情。模式结束，所以我们找到了匹配项 `123 4`。

  4. 接下来的搜索工作从字符 `5` 开始。但是剩下的不符合模式串。故结束。

- 替代方法
  惰性量词(懒惰模式的量词) 替代方法 都可以的情况

  ```js
  let reg = /"[^"]+"/g;
  // 找 [^"]+ 时，它会在匹配到结束的引号时停止重复
  let str = 'a "witch" and her "broom" is one';
  
  alert( str.match(reg) ); // witch, broom
  ```

  惰性量词失败 替代方法成功 的情况

  ```js
  let str = '...<a href="link1" class="doc">... <a href="link2" class="doc">...';
  let reg = /<a href=".*" class="doc">/g; // 贪婪模式 匹配失败
  // <a href="link1" class="doc">... <a href="link2" class="doc">
  let reg = /<a href=".*?" class="doc">/g; // 懒惰模式 匹配成功
  // <a href="link1" class="doc">, <a href="link2" class="doc">
  
  let str = '...<a href="link1" class="wrong">... <p style="" class="doc">...';
  let reg = /<a href=".*?" class="doc">/g; // 懒惰模式 匹配失败，匹配了包含 <p...> 的一段文本
  // <a href="link1" class="wrong">... <p style="" class="doc">
  /* 	
  	故懒惰模式开始不起作用了
  	我们需要寻找 <a href="...something..." class="doc">，但贪婪和懒惰模式都有一些问题。
  */
  // --------------------------------- 解决方案 ------------------------------
  let str1 = '...<a href="link1" class="wrong">... <p style="" class="doc">...';
  let str2 = '...<a href="link1" class="doc">... <a href="link2" class="doc">...';
  let reg = /<a href="[^"]*" class="doc">/g;
  str1.match(reg); // 没有匹配项，是正确的
  str2.match(reg); // <a href="link1" class="doc">, <a href="link2" class="doc">
  ```

  解决方案的执行步骤

  ```js
             ↓
     <a href="
  ...<a href="link1" class="doc">... <a href="link2" class="doc">...
  
                   ↓
     <a href="(^" )" 
  ...<a href="link1" class="doc">... <a href="link2" class="doc">...
  
                                ↓
     <a href="(^" )" class="doc">
  ...<a href="link1" class="doc">... <a href="link2" class="doc">...
  
  然后/g查到全部，，，大概就这样把。。。
  ```

-------

#### 11. 捕获组



#### 12. 模式中的反向引用：[\N]() 和 [\k<name>]()



#### 13. 选择（OR）[|]()



#### 14. 前瞻断言与后瞻断言



#### 15. 灾难性回溯



#### 16. 粘性标志 ["y"]()，在位置处搜索



#### 17. 正则表达式（RegExp）和字符串（String）的方法

   

