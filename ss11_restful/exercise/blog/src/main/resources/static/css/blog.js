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


$(document).ready(function () {
    // Function to fetch blogs and render them in the container
    function fetchBlogsAndRender() {
        $.ajax({
            url: '/api/blogs', // Replace with the correct endpoint URL
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                // Clear the container before rendering new data
                $('#blogListContainer').empty();

                // Iterate over the blogs and create HTML elements to display them
                data.forEach(function (blog) {
                    var blogHTML = `
                            <div>
                                <h2>${blog.title}</h2>
                                <p>${blog.content}</p>
                                <!-- Add other properties as needed -->
                            </div>
                        `;
                    $('#blogListContainer').append(blogHTML);
                });
            },
            error: function (error) {
                console.log('Error fetching blogs:', error);
            }
        });
    }

    // Call the function initially to render the blogs on page load
    fetchBlogsAndRender();

    // You can call the function whenever you need to refresh the blog list
    // For example, after adding, updating, or deleting a blog
    // fetchBlogsAndRender();
});

