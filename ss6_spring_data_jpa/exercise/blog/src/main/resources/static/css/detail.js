
function backToHome() {
    window.location.href = "/";
}

function toDelete(id) {
    if(confirm("Do you want to delete a blog with id :" + id)) {
        window.location.href = "/delete/" + id;
    } else {
        window.location.href = "/";
    }
}

function toEditForm(id) {
    window.location.href = "/show-edit-form/" + id;
}