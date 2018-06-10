val digits = 
  listOf(listOf(true, true, true, true, true, true, false),     // 0
	listOf(true, true, false, false, false, false, false),  // 1
	listOf(true, false, true, true, false, true, true),     // 2
	listOf(true, true, true, false, false, true, true),     // 3
	listOf(true, true, false, false, true, false, true),    // 4
	listOf(false, true, true, false, true, true, true),     // 5
	listOf(false, true, true, true, true, true, true),      // 6
	listOf(true, true, false, false, false, true, false),   // 7
	listOf(true, true, true, true, true, true, true),       // 8
	listOf(true, true, true, false, true, true, true),      // 9
	listOf(false, false, false, false, false, false, false)) // Blank


	fun lcdDigit(digit: Char, k: Int, c: Char): String {

		val arrLength = 2 * k + 3
		val arrEnd = arrLength - 1
		val arrMid = arrEnd / 2

  	    val d = if ('0' <= digit && digit <= '9') digit - '0' else 10
  	    val digi = digits[d.toInt()]

  		val table: Array<Array<Char>> = Array(arrLength, { Array(k + 2, {' '}) })

  		
	  	table[0][0] = ' '
	  	table[0][k + 1] = ' '
	  	table[arrMid][0] = ' '
	  	table[arrMid][k + 1] = ' '
	  	table[arrEnd][0] = ' '
	  	table[arrEnd][k + 1] = ' '

  	
  		var answer = ""
  	  	for ( di in digi.indices) {

  	  		if(digi[di]) {
				
  	  			var iter = 0

  	  			if(di == 0) {

  	  					while( iter < k) {
  	  						table[iter+1][k + 1] = c
  	  						iter++
  	  					
  	  					}
  	  			}

  	  			if(di == 1) {

  	  				
  	  					while( iter < k) {
  	  						iter++
  	  						table[arrMid + iter][k + 1] = c
  	  					
  	  						
  	  					}
  	  			}
  	  			if(di == 2) {

  	  				
  	  					while( iter < k) {
  	  						iter++
  	  						table[arrEnd][iter] = c
  	  						
  	  						
  	  					}
  	  			}
  	  			if(di == 3) {

  	  				
  	  					while( iter < k) {
  	  						iter++
  	  						table[arrMid + iter][0] = c  	  						
  	  					}

  	  			}
  	  			if(di == 4) {

  	  				
  	  					while( iter < k) {
  	  						table[iter+1][0] = c
  	  						iter++
  	  						
  	  					}
  	  			}
  	  			if(di == 5) {

  	  				
  	  					while( iter < k) {
  	  						iter++
  	  						table[0][iter] = c
  	  					}
  	  			}
  	  			if(di == 6) {

  	  				
  	  					while( iter < k) {
  	  						iter++
  	  						table[arrMid][iter] = c
  	  					}
  	  			}

  	  		}
  	  	}

        var strr = ""
  	  	for (t in table) {

          answer = answer + strr
  	  		for (i in t)  {
  	  			
  	  			answer = answer + i 
  	  		}
  	  			
  	  			strr = "\n"
  	  	}
  	  
  	  	return answer
	}


fun combine(left: String, sep: String, right: String): String {
   
	var leftArr = left.split("\n")
	var rightArr = right.split("\n")
  var di = ""
  
  for (i in leftArr.indices) {

  
       di = di + leftArr[i] + sep + rightArr[i] 
       if(i < leftArr.size - 1) {
          di = di + "\n"
       }

  }
	return di
}


fun lcd(s: String, k: Int, c: Char, sep: String): String {
  var result = lcdDigit(s[0], k, c)

  for (i in 1 until s.length){
    
   result = combine(result, sep, lcdDigit(s[i], k, c))
  }
     println(result)
  return result
}

fun clearScreen() {
  println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
}

fun clock() {
  val form = java.text.SimpleDateFormat("HH mm ss")
  var current = form.format(java.util.Calendar.getInstance().getTime())
  clearScreen()
  println(lcd(current, 4, '#', " "))
  while (true) {
    Thread.sleep(100)
    val ntime = form.format(java.util.Calendar.getInstance().getTime())
    if (ntime != current) {
      current = ntime
      clearScreen()
      println(lcd(current, 4, '#', " "))
    }
  }
}

clock()