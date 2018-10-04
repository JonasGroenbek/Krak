import 'bootstrap/dist/css/bootstrap.css'
import jokes from "./jokes";



const body = document.getElementsByName('body');
//bruges til POST metode
//bruges til at hente udfra id (men er lavet som navn for at teste)
const id = document.getElementById("id");
const button = document.getElementById("btngetall")
const buttonID = document.getElementById("btngetid")




//metode til at hente alle personer ud på en smartere måde, hvor vi ikke generere
//en html streng men lave en html template

document.getElementById("btngetall").addEventListener("click", function(){
    fetch("http://uinames.com/api/?amount=50&region=denmark&gender=female")
    .then((response) => response.json())
            .then((data) =>{
                let output = " ";
                data.forEach(function(data){
                    output += `
                    <tr>
                      <td>name: ${data.name} </td>
                      <td>surname: ${data.surname} </td>
                      <td>gender: ${data.gender} </td>
                    </tr>
                      `;
                });
                document.getElementById('tblbody').innerHTML = output;
            });
        });
    

//metode for at hente alle personer ud 
/*
button.addEventListener("click", function(){
    let txt  = " ";
    console.log("hej")
    fetch("http://uinames.com/api/?amount=50&region=denmark&gender=female").then(
        function(response){
            if(response.status >= 400){
                console.log("ERROR more then 500 names requested");
                alert("Don't request so many names");
            }
            return response.json();
        }).then(function(jsonData){
                console.log(jsonData);
                for(var i = 0; i < jsonData.length; ++i){
                  console.log(body);
                    console.log(jsonData.length);
                    console.log("first name is " + jsonData[0].name);
                     txt += "<tr><td>" + jsonData[i].name + "</td>" + "<td>"+  jsonData[i].surname + "</td>"  + "<td>" +  jsonData[i].gender + "</td></tr>"; 
                }
                document.getElementById("tblbody").innerHTML = txt;
                //document.getElementById("json").innerHTML = JSON.stringify(jsonData);
                
                console.log(2);
                
            });
        });
*/


//metode til at hente alle personer via ID
//metode for at hente alle personer ud via navn er lavet her som en test

buttonID.addEventListener("click", function(){
    let txt  = " ";
  
    fetch("http://uinames.com/api/?amount=25&region=denmark&gender=female").then(
        function(response){
            if(response.status >= 400){
                console.log("ERROR more then 500 names requested");
                alert("Don't request so many names");
            }
            return response.json();
        }).then(function(jsonData){
            console.log("hej")
                for(var i = 0; i < jsonData.length; ++i){
                if(jsonData[i].name ===id.value){  
                     txt += "<tr><td>" + jsonData[i].name + "</td>" + "<td>"+  jsonData[i].surname + "</td>"  + "<td>" +  jsonData[i].gender + "</td></tr>"; 
                }
            }
                document.getElementById("tblbody").innerHTML = txt;
                //document.getElementById("json").innerHTML = JSON.stringify(jsonData);
                
         
                
            });
        });

       document.getElementById("addPost").addEventListener("click", function(e){
            e.preventDefault();
        
            let title = document.getElementById("title").value;
            let body = document.getElementById("body").value;
            
            fetch("https://jsonplaceholder.typicode.com/posts", {
                method: 'POST',
                headers: {
                    'Accept': 'application/json, text/plain, */*',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({title: title, body: body})
            })
                .then((res) => res.json())
                .then((data) => console.log('Succes' + JSON.stringify(data) + ' was uploaded'))
                .catch(error => console.error('Error: ' + error))
            });
        

        /*
        metoder for at poste personer men den er ikke færdig
        addPost.addEventListener("click", function(e){
            e.preventDefault();
        
            let fname = document.getElementById("fname").value;
            let lname = document.getElementById("lname").value;
            let email = document.getElementById("email").value;
                    
        
            fetch(url, {
                method: 'POST',
                headers: {
                    'Accept': 'application/json, text/plain,',
                    'Content-Type': 'application/json'
                },
                body: JSON.Stringify({fname: fname, lname: lname, email: email
                })
                .then((res) => res.json())
                .then((data) => console.log(data))
            })
        });  
 */