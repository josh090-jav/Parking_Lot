package parking

import java.util.*

fun main() {
    val lots = mutableListOf<String>()
    // repeat(20){lots.add("null")}
    var entr = ""
    while (entr != "exit") {
        val create = readLine()!!.split(" ")
        if(create[0] == "create") {
            println("Created a parking lot with ${create[1]} spots.")
            while(entr != "exit") {
                if (lots.size == 0) {
                    var numCreated = create[1].toInt()
                    if (numCreated <= 0) {
                        numCreated = 1
                    }
                    repeat(numCreated){lots.add("null")}
                }
                val ent = readLine()!!.split(" ")
                if(ent[0] != "exit") {
                    // var ent = entr.split(" ")
                    if ("park" == ent[0]) {
                        for(p in 0 until lots.size) {
                            if (lots[p] == "null") {
                                lots[p] = "${ent[1]} ${ent[2]}"
                                println("${ent[2]} car parked in spot ${p + 1}.")
                                break
                            } else if (p == lots.size - 1) {
                                println("Sorry, the parking lot is full.")
                                // break
                            }
                        }
                    }

                    if ("leave" == ent[0]) {
                        if (lots[ent[1].toInt() - 1] == "null") {
                            println("There is no car in spot ${ent[1]}.")
                        } else {
                            lots[ent[1].toInt() - 1] = "null"
                            println("Spot ${ent[1]} is free.")
                        }
                    }

                    if("spot_by_color" == ent[0]) {
                        var count = 0
                        val tempList = mutableListOf<String>()
                        for(w in 0 until lots.size) {
                            if(ent[1].toLowerCase() == lots[w].substringAfter(" ")
                                    .lowercase()) {
//                                println(w)
                                tempList.add("${w + 1}")
                                ++count
                            }
                            if(w == lots.size - 1 && count <= 0) {
                                println("No cars with color ${ent[1]} were found.")
                            }
                        }
                        if(tempList.size > 0) println(tempList.joinToString (", "))
                    }

                    if("spot_by_reg" == ent[0]) {
                        var count = 0
                        val tempList = mutableListOf<String>()
                        for(w in 0 until lots.size) {
                            if(ent[1] == lots[w].substringBefore(" ")) {
//                                println(w)
                                tempList.add("${w + 1}")
                                ++count
                            }

                            if(w == lots.size - 1 && count <= 0) {
                                println("No cars with registration number ${ent[1]} were found.")
                            }
                        }
                        if(tempList.size > 0) println(tempList.joinToString (", "))
                    }

                    if("reg_by_color" == ent[0]) {
                        var count = 0
                        val tempList = mutableListOf<String>()
                        for(w in 0 until lots.size) {
                            if(ent[1].toLowerCase() == lots[w].substringAfter(" ")
                                    .lowercase(Locale.getDefault())) {
//                                print("${lots[w].substringAfter(" ")} ")
                                tempList.add(lots[w].substringBefore(" "))
                                ++count
                            }

//                            println(tempList.size)
                            if(w == lots.size - 1 && count <= 0) {
                                println("No cars with color ${ent[1]} were found.")
                            }
                        }
                        if(tempList.size > 0) println(tempList.joinToString (", "))
                    }

                    if ("status" == ent[0]) {
                        var ww = 0
                        (lots).forEach{
                            if(it != "null") ++ww
                        }
                        if (ww > 0) {
                            for (w in 0 until lots.size) {
                                if (lots[w] != "null") {
                                    println("${w + 1} ${lots[w]}")
                                }
                            }
                        } else if(ww <= 0) {
                            println("Parking lot is empty.")
                        }
                    }

                    if ("create" == ent[0]) {
                        lots.clear()
                        repeat(ent[1].toInt()) {
                            lots.add("null")
                        }
                        println("Created a parking lot with ${ent[1]} spots.")
                    }

                }
                entr = ent[0]
            }

        } else if(create[0] == "park" || create[0] == "leave" || create[0] == "status"
            || create[0] == "spot_by_reg" || create[0] == "spot_by_color" || "reg_by_color" == create[0]) {
            println("Sorry, a parking lot has not been created.")
        } else if (create[0] == "exit") {
            entr = "exit"
        }

    }
    // val col = entry[]
//    fun status() {
//
//        var w = 0
//        (lots).forEach{
//            if(it != "null") ++w
//        }
//        if (w > 0) {
//            for (w in 0 until lots.size) {
//                if (lots[w] != "null") {
//                    println("$w ${lots[w]}")
//                }
//            }
//        } else if(w <= 0) {
//            println("Parking lot is empty.")
//        }
//
//    }
    // println()

}




