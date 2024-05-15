var days = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];

var months = ["January","February","March","April","May","June","July","August","September","October","November","December"];

let now;
let date;
let month;
let day;
let year;
let hour;
let minute;
let second;
let alarm1;
let alarm2;
let flag="true";
let end;
let a;
let b;
let c;
let d;
let e;
let f;
let g;
let h;


let onetwo=function clock1()
{
    now=new Date();
    date=now.getDate();
    month=now.getMonth();
    day=now.getDay();
    year=now.getFullYear();
    hour=now.getHours();
    minute=now.getMinutes();
    second=now.getSeconds();
    a=document.getElementById("date");
    b=document.getElementById("day");
    c=document.getElementById("month");
    d=document.getElementById("year"); 
    e=document.getElementById("hour");
    f=document.getElementById("minutes");
    g=document.getElementById("seconds");
    h=document.getElementById("format"); 
    a.textContent=date;
    b.textContent=days[day];
    c.textContent=months[month];
    d.textContent=year;
    if(hour>12)
    {
        let num=hour%12;
        e.textContent=num;
    }
    else{
        e.textContent=hour<10 ? "0"+hour : hour;
    }
    f.textContent=minute<10 ? "0"+minute:minute;
    g.textContent= second<10 ? "0"+second : second; 
    h.textContent=hour>=12 ? "PM" : "AM";

    if(!(set3.value=="" || set3.value>13) && !(set4.value=="" || set4.value>60) && (set5.value=="AM" || set5.value=="PM") )
        {
            if(set3.value==e.textContent && set4.value==f.textContent && set5.value==h.textContent && (second>=0 || second<=59))
            {
                document.getElementById("bellicon").style.display="none";
                document.getElementById("snooze").style.display="block";
                document.getElementById("myaudio1").play();
            }
            if(set3.value==e.textContent && set4.value==f.textContent && set5.value==h.textContent && (second>=0 || second<=59))
            {
                document.getElementById("hourvalidation1").style.visibility="visible";
                document.getElementById("hourvalidation1").style.color="red";
                document.getElementById("hourvalidation1").textContent="current time";
                document.getElementById("minutevalidation1").style.visibility="visible";
                document.getElementById("minutevalidation1").textContent="current time";
                document.getElementById("minutevalidation1").style.color="red";
                // document.getElementById("myaudio1").pause();
                // document.getElementById("bellicon").style.display="none";
                // document.getElementById("snooze").style.display="none";
            } 
        }
}

let twofour=function clock2()
{
    now=new Date();
    date=now.getDate();
    month=now.getMonth();
    day=now.getDay();
    year=now.getFullYear();
    hour=now.getHours();
    minute=now.getMinutes();
    second=now.getSeconds();
    a=document.getElementById("date");
    b=document.getElementById("day");
    c=document.getElementById("month");
    d=document.getElementById("year"); 
    e=document.getElementById("hour");
    f=document.getElementById("minutes");
    g=document.getElementById("seconds");
    h=document.getElementById("format"); 
    a.textContent=date;
    b.textContent=days[day];
    c.textContent=months[month];
    d.textContent=year;
    e.textContent=hour<10 ? "0"+hour : hour;
    f.textContent=minute<10 ? "0"+minute:minute;
    g.textContent= second<10 ? "0"+second : second; 
    h.textContent="RT";
    if(!(set1.value=="" || set1.value>25) && !(set2.value=="" || set2.value>60))
        {
            if(set1.value==hour && set2.value==minute && (second>=0 || second<=59))
            {
                document.getElementById("bellicon").style.display="none";
                document.getElementById("snooze").style.display="block";
                document.getElementById("myaudio").play();
            }
            else{
                document.getElementById("snooze").style.display="none";
            }
            if(set1.value==hour && set2.value==minute && (second>=0 || second<=59))
            {
                document.getElementById("hourvalidation").style.visibility="visible";
                document.getElementById("hourvalidation").style.color="red";
                document.getElementById("hourvalidation").textContent="current time";
                document.getElementById("minutevalidation").style.visibility="visible";
                document.getElementById("minutevalidation").textContent="current time";
                document.getElementById("minutevalidation").style.color="red";
                
            } 
        }
}

let start=setInterval(twofour,1000);
// let start=setInterval(onetwo,1000);

let click=document.getElementById("baricon");
click.addEventListener("click",()=>{
    if(flag=="true")
    {
        flag="false";
        document.getElementById("parentdiv").style.display="block";
    }
    else{
        flag="true";
        document.getElementById("parentdiv").style.display="none";
    }
})


let set1=document.getElementById("set1");
set1.addEventListener("focusout",()=>{
    if(set1.value=="" || set1.value>25)
    {
        document.getElementById("hourvalidation").style.visibility="visible";
        document.getElementById("hourvalidation").style.color="red";
        document.getElementById("hourvalidation").textContent="Please fill this";
    }
    else{
        document.getElementById("hourvalidation").style.color="green";
        document.getElementById("hourvalidation").textContent="valid";
        console.log(set1.value);
        console.log(e.textContent);
    }
})

let set3=document.getElementById("set3");
set3.addEventListener("focusout",()=>{
    if(set3.value=="" || set3.value>25)
    {
        document.getElementById("hourvalidation1").style.visibility="visible";
        document.getElementById("hourvalidation1").style.color="red";
        document.getElementById("hourvalidation1").textContent="Please fill this";
    }
    else{
        document.getElementById("hourvalidation1").style.color="green";
        document.getElementById("hourvalidation1").textContent="valid";
        console.log(set3.value);
    }
})

let set2=document.getElementById("set2");
set2.addEventListener("focusout",()=>{
    if(set2.value=="" || set2.value>60)
    {
        document.getElementById("minutevalidation").style.visibility="visible";
        document.getElementById("minutevalidation").textContent="Please fill this";
        document.getElementById("minutevalidation").style.color="red";
    }
    else{
        document.getElementById("minutevalidation").textContent="valid";
        document.getElementById("minutevalidation").style.color="green";
        console.log(set2.value);
    }
})

let set4=document.getElementById("set4");
set4.addEventListener("focusout",()=>{
    if(set4.value=="" || set4.value>60)
    {
        document.getElementById("minutevalidation1").style.visibility="visible";
        document.getElementById("minutevalidation1").textContent="Please fill this";
        document.getElementById("minutevalidation1").style.color="red";
    }
    else{
        document.getElementById("minutevalidation1").textContent="valid";
        document.getElementById("minutevalidation1").style.color="green";
        console.log(set4.value);
    }
})

let set5=document.getElementById("set5");
set5.addEventListener("focusout",()=>{
    if(set5.value=="AM" || set5.value=="am" || set5.value=="aM" || set5.value=="Am" ||set5.value=="PM" || set5.value=="pm" || set5.value=="pM" || set5.value=="Pm")
        {
            document.getElementById("formatvalidation").textContent="valid";
            document.getElementById("formatvalidation").style.color="green";
            console.log(set5.value);
        }
        else{
            document.getElementById("formatvalidation").style.visibility="visible";
            document.getElementById("formatvalidation").textContent="Please fill 'Am' or 'Pm' ";
            document.getElementById("formatvalidation").style.color="red";
        }
})

let overall=document.getElementById("parentdiv");
overall.addEventListener("click",(even)=>{
    let target1=even.target;
    if(target1.id=="formatbutton2")
    {
        clearInterval(start);
        end=setInterval(onetwo,1000);
        document.getElementById("item2").style.display="none";
        document.getElementById("item1").style.display="block";
    }
    
    if(target1.id=="formatbutton1")
    {
        clearInterval(end);
        start=setInterval(twofour,1000);
        document.getElementById("item1").style.display="none";
        document.getElementById("item2").style.display="block";
    }

    if(target1.id=="alarmbutton")
    {
        document.getElementById("item3").style.display="none";
        document.getElementById("item4").style.display="block";
        document.getElementById("item5").style.display="block";
        document.getElementById("item6").style.display="none";
    }

    if(target1.id=="alarmbutton1")
    {
        document.getElementById("item4").style.display="none";
        document.getElementById("item3").style.display="block";
        document.getElementById("item6").style.display="block";
        document.getElementById("item5").style.display="none";
    }

    if(target1.id=="alarmok")
    {
        if(set1.value=="" || set1.value>25)
        {
            document.getElementById("hourvalidation").style.visibility="visible";
            document.getElementById("hourvalidation").style.color="red";
            document.getElementById("hourvalidation").textContent="Please fill this";
        }
        else 
        {
            document.getElementById("hourvalidation").style.color="green";
            document.getElementById("hourvalidation").textContent="valid";
        }

        if(set2.value=="" || set2.value>60)
        {
            document.getElementById("minutevalidation").style.visibility="visible";
            document.getElementById("minutevalidation").textContent="Please fill this";
            document.getElementById("minutevalidation").style.color="red";
        }
        else{
            document.getElementById("minutevalidation").textContent="valid";
            document.getElementById("minutevalidation").style.color="green";
        }
        if(!(set1.value=="" || set1.value>25) && !(set2.value=="" || set2.value>60))
        {
            document.getElementById("bellicon").style.display="inline"
            flag="true";
            document.getElementById("parentdiv").style.display="none";
        }
        
    }

    if(target1.id=="alarmok1")
    {
        if(set3.value=="" || set3.value>13)
        {
        document.getElementById("hourvalidation1").style.visibility="visible";
        document.getElementById("hourvalidation1").style.color="red";
        document.getElementById("hourvalidation1").textContent="Please fill this";
        }
        else{
        document.getElementById("hourvalidation1").style.color="green";
        document.getElementById("hourvalidation1").textContent="valid";
        }

        if(set4.value=="" || set4.value>60)
        {
        document.getElementById("minutevalidation1").style.visibility="visible";
        document.getElementById("minutevalidation1").textContent="Please fill this";
        document.getElementById("minutevalidation1").style.color="red";
        }
        else{
        document.getElementById("minutevalidation1").textContent="valid";
        document.getElementById("minutevalidation1").style.color="green";
        }
        
        if(set5.value=="AM" || set5.value=="am" || set5.value=="aM" || set5.value=="Am")
        {
            document.getElementById("formatvalidation").textContent="valid";
            document.getElementById("formatvalidation").style.color="green";
            document.getElementById("bellicon").style.display="inline";
        }
        else{
            document.getElementById("formatvalidation").style.visibility="visible";
        document.getElementById("formatvalidation").textContent="Please fill 'Am' or 'Pm' ";
        document.getElementById("formatvalidation").style.color="red";
        }
    }

    if(target1.id=="snooze1")
    {
        document.getElementById("myaudio").setAttribute("autoplay","false");
    }
})





