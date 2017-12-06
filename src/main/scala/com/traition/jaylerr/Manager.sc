val ioob:String = "The index is out of bound"

val ls: List[Int] = List(1, 1, 2, 3, 5, 8)
val adList: List[Symbol] = List('a, 'b, 'c, 'd)
val afList: List[Symbol] = List('a, 'b, 'c, 'd, 'e, 'f)
val ahList: List[Symbol] = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h)

def printList(list: List[Any]): Unit = {
  var int:Int = 0
  print("Print : ")
  while (int < list.length){
    print(" ".concat(list(int).toString))
    int += 1
  }
}

//add list
def addItemToList[A](list: List[A], any: A): List[A] = {
  val newList  = list :+ any
  newList
}

def mergeList(originlist: List[Any], list: List[Any]): List[Any] = {
  val newList = originlist ::: list
  newList
}

//1
def last(list: List[Int]): Int = list(list.length - 1)

//2
def penultimate(list: List[Int]): Int = list(list.length - 2)

//3
def nth(int: Int, list: List[Int]): Int = {
  var length:Int = 0
  while(list(length) != int){
    length+=1
  }
  list(length)
}

//4
def lengthOfList(list: List[Int]): Int = list.length

//5
def reverse(list: List[Int]): List[Any] = {
  var  listR:List[Int] = List()
  listR = list.reverse
  listR
}

//6
def isPalindrome(list: List[Int]): Boolean = {
  var result:Boolean = true
  var num:Int = 0
  while (num < list.length/2){
    if (list(num) != list(list.length - (num +1) )){
      num+=1
      result = false
    }
  }
  result
}

//7
def flatten(list: List[Any]): List[Any] = list match {
  case Nil => Nil
  case (a: Int) :: tail => a :: flatten(tail)
  case (a: List[Any]) :: tail => flatten(a) ::: flatten(tail)
  case _ :: tail => flatten(tail)
}

//8
def compress(list: List[Any]): List[Any] ={
  var newList:List[Any] = List()
  var lastElement:Any = ""
  var number:Int = 0
  while (number < list.length){
    if(number != 0){
      if (lastElement != list(number)){
        lastElement = list(number)
        newList = addItemToList(newList, lastElement)
      }
    } else {
      lastElement = list(number)
      newList = addItemToList(newList, lastElement)
    }

    number +=1
  }
  newList
}

//9
def pack(list: List[Any]): List[Any] = {
  var num:Int = 0
  var newList:List[Any] = List()
  var tempList:List[Any] = List()
  var lastItem:Any = list(0)

  while (num < list.length - 1){
    num += 1
    if (lastItem == list(num)){
      tempList = addItemToList(tempList, lastItem)
    } else {
      newList = addItemToList(newList, tempList)
      tempList = List()

      lastItem = list(num)
      tempList = addItemToList(tempList, lastItem)
    }
  }
  newList = addItemToList(newList, tempList)
  //printList(newList)
  newList
}

//10
//def encode(list: List[Any]): List[Any] = {
//  var subList:List[Any] = List()
//  var newList:List[Any] = List()
//  var tempList:List[Any] = List()
//  var num:Int = 0
//  while (num < list.length){
//    subList = list(num)
//    tempList = addItemToList(tempList, subList.length)
//    tempList = addItemToList(tempList, subList.head)
//    newList = addItemToList(newList, tempList)
//    tempList = List()
//    num += 1
//  }
//
//  newList
//
//}

//11

//12

//13

//14
def duplicate[A](list: List[A]): List[A] = {
  list.flatMap(x => List.fill(2)(x))
}

//15
def duplicateN[A](int: Int, list: List[A]): List[A] = {
  list.flatMap(x => List.fill(int)(x))
}

//16
def drop[A] (int: Int, list: List[A]): List[A] = {
  if (int < list.size){
    val newList = list.take(int - 1) ++ list.drop(int)
    newList
  } else {
    print(ioob)
    null
  }

}

//17
def split(int: Int, list: List[Any]): List[Any] = {
  if (int < list.size){
    var newList:List[Any] = List()
    newList = addItemToList(newList, list.take(int))
    newList = addItemToList(newList, list.drop(int))
    newList
  } else {
    print(ioob)
    null
  }
}

//18
def slice(x:Int, y:Int, list: List[Any]): List[Any] = {
  if (x > 0 && y > x && y < list.size){
    val xList = list.drop(x)
    val yList = xList.take(y-x)
    yList
  } else {
    print(ioob)
    null
  }
}

//19
def rotate(int: Int, list: List[Any]): List[Any] = {
  var  n:Int = int
  if (int < 0){
    n = list.size + int
  }
  var nList:List[Any] = List()
  var hList:List[Any] = List()
  var tList:List[Any] = List()
  if (n < list.size && n >= 0){
    tList = list.take(n)
    hList = list.drop(n)
    nList = hList ::: tList
    nList
  } else {
    print(ioob)
    null
  }

}

//20
def removeAt(int: Int, list: List[Any]):List[Any] = {
  if (int < list.size){
    val ra = list(int)
    val tempList = drop(int+1, list)
    var nList:List[Any] = List()
    nList = addItemToList(nList, tempList)
    nList = addItemToList(nList, ra)
    nList
  } else {
    print(ioob)
    null
  }
}

//21
def insertAt(any: Any, int: Int, list: List[Any]): List[Any] = {
  if (int <= list.size){
    val hl:List[Any] = list.take(int)
    val tl:List[Any] = list.drop(int)
    val nl:List[Any] = hl ::: any :: tl
    nl
  } else {
    print(ioob)
    null
  }
}

//22
def range(x: Int, y: Int): List[Int] = {
  if (y > x){
    val nl:List[Int] = List.range(x,y+1)
    nl
  } else {
    print("Invalid input")
    null
  }
}

//23
def randomSelect(int: Int, list: List[Any]):List[Any] = {
  var i:Int = 0
  var num:Int = 0
  var rl:List[Int] = List()
  var r = scala.util.Random
  var nl:List[Any] = List()
  while (i < int){
    num = r.nextInt(int)
    if (!(rl.contains(num))){
      nl = addItemToList(nl, list(num))
      rl = addItemToList(rl, num)
      i+=1
    }
  }
  nl
}

//24
def lotto(x:Int, y:Int):List[Int] = {
  var i:Int = 0
  var lottoList:List[Int] = List()
  var r = scala.util.Random
  while (i < x){
    val num:Int = r.nextInt(y)
    if (!(lottoList.contains(num))){
      lottoList = addItemToList(lottoList, num)
      i+=1
    }
  }
  lottoList
}

//25
def randomPermute(list: List[Symbol]): List[Symbol] = {
  var i:Int = 0
  var nl:List[Symbol] = List()
  var numList:List[Int] = List()
  var r = scala.util.Random
  while (i < list.size){
    val num:Int = r.nextInt(list.size)
    if (!(numList.contains(num))){
      numList = addItemToList(numList, num)
      nl = addItemToList(nl, list(num))
      i+=1
    }
  }
  print("Original : ")
  printList(list)
  println()
  nl
}

//26
def flatMapSubLists[A,B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
  ls match {
    case Nil => Nil
    case sublist@(_ :: tail) => f(sublist) ::: flatMapSubLists(tail)(f)
  }

def combinations[A](n: Int, ls: List[A]): List[List[A]] =
  if (n == 0) List(Nil)
  else flatMapSubLists(ls) { sl =>
    combinations(n - 1, sl.tail) map {sl.head :: _}
  }

//27
//def group3[A](ls: List[A]): List[List[List[A]]] =
//  for {
//    a <- combinations(2, ls)
//    noA = ls -- a
//    b <- combinations(3, noA)
//  } yield List(a, b, noA -- b)
//
//def group[A](ns: List[Int], ls: List[A]): List[List[List[A]]] = ns match {
//  case Nil     => List(Nil)
//  case n :: ns => combinations(n, ls) flatMap { c =>
//    group(ns, ls -- c) map {c :: _}
//  }
//}

//28
def lSort[A](list: List[A]):List[A] = {
  null
}

//29

//30

//31

//32
def gcd(a:Int, b:Int): Int = {
  var result: Boolean = true
  var x:Int = 0
  var y:Int = 0
  var  i:Int = 1
  if (b>a){
    x = a
    y = b
  } else {
    x = b
    y = a
  }
  var z:Int = 0
  while (result){
    z = x/i
    println("Y%Z = "+y%z)
    if (y%z == 0){
      result = false
    } else if (i >= x/2){
      result = false
      z = 0
    }
    i+=1
  }
  print("GCD of two positive integer numbers. : ")
  if (z == 0){
    print(" Nothing is GCD for this ")
    z
  } else z
}
/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////
//1
last(ls)
//2
penultimate(ls)
//3
nth(2,ls)
//4
lengthOfList(ls)
//5
reverse(ls)
//6
isPalindrome(ls)
//7
flatten(List(List(1, 1), 2, List(3, List(5, 8))))
//8
compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//9
val packList = pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e,
  'e, 'e, 'e))
//10
//encode(packList)
//11
//12
//13
//14
duplicate(adList)
//15
duplicateN(3, adList)
//16
val akList: List[Any] = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
drop(3, akList)
//17
split(3, akList)
//18
slice(3, 7, akList)
//19
rotate(3, akList)
rotate(-2, akList)
//20
removeAt(1, List('a, 'b, 'c, 'd))
//21
insertAt('new, 1, List('a, 'b, 'c, 'd))
//22
range(4,9)
//23
randomSelect(3, ahList)
//24
lotto(6, 49)
//25
randomPermute(afList)
//26
//combinations(3, afList)
// It's ok but i'm bore it because it away slide the screen
//27
//group(List(2, 2, 5), List("Aldo",
// "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
//28
lSort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e),
  List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
//29
//30
//31

//32
gcd(36, 163)
//33
//34
//35
//36
//37
//38
//39
//40
//41
//42
//43
//44
//45
//46
//47
//48
//49
//50
//51
//52
//53
//54
//55
//56
//57
//58
//59
//60
//61
//62
//63
//64
//65
//66
//67
//68
//69
//70
//71
//72
//73
//74
//75
//76
//77
//78
//79
//80
//81
//82
//83
//84
//85
//86
//87
//88
//89
//90
//91
//92
//93
//94
//95
//96
//97
//98
//99