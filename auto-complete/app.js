// declare a variable that will store the array of words the user may enter

var random = ["hello", "goodbye", "help", "call", "create", "make", "invest", "use", "append", "greet", "seat", "ink", "eat", "alert" ];

// declare a function that creates and hides a field that displays our "auto-complete" words
            function setText(ntext){
                document.getElementsByClassName("newText")[0].value = ntext;
                var resdiv = document.getElementsByClassName("result")[0];
                resdiv.innerHTML = "";
                resdiv.style.visibility = "hidden";
            };
            
            function myFunction(){
                var newTextText = document.getElementsByClassName("newText")[0].value;
                //console.log(newTextText);
                
                //clear autocomplete div
                var resdiv = document.getElementsByClassName("result")[0];
                resdiv.innerHTML = "";
                resdiv.style.visibility = "hidden";
                
                if (newTextText == ""){
                    return;
                }
                
                for(i=0; i<random.length; i++){
                    
                    // loop through all the "auto-complete" words that matches the characters entered character for character
                    if(random[i].indexOf(newTextText.toLowerCase())>=0){
                        // console.log(random[i]);
                        resdiv.style.visibility = "visible"; // set the "auto-complete" words container visible
                        resdiv.innerHTML = resdiv.innerHTML+"<a href='#' onclick=\"setText('"+random[i]+"')\">"+random[i]+"</a>"+"<br />";
                       
                   };
                }
                    
            }