
// check if ch is a letter
fun isLetter(ch: Char) = ch in 'a'..'z' || ch in 'A'..'Z'

// shuffle(s) returns a randomly shuffled copy of the string s
fun shuffle(s: String): String {
  val l = s.toMutableList()
  java.util.Collections.shuffle(l)
  return l.joinToString("")
}

fun reorderLetters(s: String) {
  var i = 0
  var end = 0
  var d = 0
  while (i < s.length) {
    // modify this space
     if (i + 1 == s.length) {
           break
        }
        
    if(!isLetter(s[i])){
      print(s[i])
      i++
    }
    if(isLetter(s[i])){
      var answer = ""
      print(s[i])
      end = i

      
      while(s[end] != ' ' && s[end] != '.') {
        
        end++
       
        if (end + 1 == s.length) {
           break
        }
      }
      
      d = i + 1
      while(d < end-1) {
        answer = answer + s[d]
        d++
      }
      answer = shuffle(answer)
      print(answer)
      print(s[end-1])
      i = end
    }

  }
  println()
}


if (args.size != 1)
  println("Usage: kts readable.kts <filename>")
else
  java.io.File(args[0]).forEachLine { reorderLetters(it) }