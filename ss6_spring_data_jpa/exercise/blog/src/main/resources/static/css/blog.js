let noOfCharacter = 100;

let contents = document.querySelectorAll(".content");

contents.forEach(content => {
//     If text length is less than 50 hide the content
    if (content.textContent.length > 50) {
        let displayText = content.textContent.slice(0,noOfCharacter);
        let moreText = content.textContent.slice(noOfCharacter);
        content.innerHTML = `${displayText}<span class="dots">...</span><span class="hide-text">${moreText}</span>`
    }
})

let msgElement = document.getElementById("msg");
let msg = msgElement.innerText;
if (msg) {
    window.alert(msg);
}