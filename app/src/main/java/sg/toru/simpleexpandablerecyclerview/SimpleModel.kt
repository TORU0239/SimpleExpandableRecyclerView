package sg.toru.simpleexpandablerecyclerview

open class SimpleModel(var movieName:String = "",
                       var movieGenre:String = "",
                       var directorName:String = "",
                       var year:String = "")

class ExpandableModel(var expanded:Boolean):SimpleModel()