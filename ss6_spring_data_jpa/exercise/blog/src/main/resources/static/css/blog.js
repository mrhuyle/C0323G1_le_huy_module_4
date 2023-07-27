let noOfCharacter = 100;

let contents = document.querySelectorAll(".content");

contents.forEach(content => {
//     If text length is less than 100 hide the content
    if (content.textContent.length > 50) {
        let displayText = content.textContent.slice(0, noOfCharacter);
        let moreText = content.textContent.slice(noOfCharacter);
        content.innerHTML = `${displayText}<span class="dots">...</span><span class="hide-text">${moreText}</span>`
    }
})

let msgElement = document.getElementById("msg");
let msg = null;
if (msgElement) {
    msg = msgElement.innerText;
}
if (msg) {
    window.alert(msg);
}


function search() {
    let searchQuery = document.getElementById("searchInput").value.trim();
    console.log(searchQuery);
    if (searchQuery !== "") {
        window.location.href = "/?search=" + encodeURIComponent(searchQuery);
    } else {
        window.location.href = "/";
    }
}


