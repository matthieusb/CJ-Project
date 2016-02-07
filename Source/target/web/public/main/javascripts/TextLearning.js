function in_array(value, array) {
    var res = "0";
    var length = array.length;
    for(var i =0; i<length; ++i){
        if (array[i] == value){
            res = value;
        }
    }
    return res;
}

function intersect(a, b) {
    var ai=0, bi=0;
    var result = [];

    while( ai < a.length && bi < b.length )
    {
        if      (a[ai] < b[bi] ){ ai++; }
        else if (a[ai] > b[bi] ){ bi++; }
        else /* they're equal */
        {
            result.push(a[ai]);
            ai++;
            bi++;
        }
    }

    return result;
}

function learning(text) {
    var langages = ["python", "php", "java", "scala", "c++", "pascal", "ocaml", "fortran", "c", "ruby", "groovy", "perl", "lisp"];
    var voc_fr = ["informatique", "calcul","ordinateur", "machine", "programmation"];
    var voc_en = ["calculus", "computer", "programming"];
    var voc_python = ["nature", "dangeureux", "serpent", "snake", "anaconda"];
    var voc_scala = ["milan", "italie", "italy", "concerto", "opera", "song", "songs"];
    var voc_ruby = ["expensive", "cher", "pierre", "bijou", "jewel"];
    var voc_groovy = ["fun", "exciting", "fashion"];

    var score = 0;

    var text2 = text.toLowerCase()
    var split_text = text2.split(" ");

    var i_lang_text = intersect(split_text, langages);

    var i_fr_text = intersect(split_text, voc_fr);

    var i_en_text = intersect(split_text, voc_en);

    if(i_lang_text.length == 0){
        var i_py_text = [];
        var i_gr_text = [];
        var i_sc_text = [];
        var i_ru_text = [];
    } else {
        var i_py_text = intersect(split_text, voc_python);

        var i_sc_text = intersect(split_text, voc_scala);

        var i_ru_text = intersect(split_text, voc_ruby);

        var i_gr_text = intersect(split_text, voc_groovy);
    }

    if((i_lang_text.length!=0) || (i_fr_text.length !=0) || (i_en_text.length!=0)){
        score++;
    } else if ((i_lang_text.length!=0) && ((i_py_text.length!=0) || (i_sc_text.length!=0) || (i_ru_text.length!=0) || (i_gr_text.length!=0))){
        score--;
    } else {
        score--;
    }

    return (score >= 1);
}
