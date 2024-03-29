
// UpdateFormWithPreviousValues takes a list of previous values and inserts them into the value text on the form
function UpdateFormWithPreviousValues(form ,previousValues) {
    // for each child element of the form (can be label, input or textarea)
    form.reset();
    let count = 0;
    for (let i = 0; i < form.childNodes.length; i++) {
        {
            // if input or textarea
            if (form.childNodes[i].tagName === "INPUT") {
                // set value text to previous value
                console.log(previousValues[count]);
                form.childNodes[i].setAttribute("value", previousValues[count]);
                count++;
            } else if (form.childNodes[i].tagName === "TEXTAREA") {
                form.childNodes[i].innerHTML = previousValues[count];
                count++;
            }
        }
    }
}

// SetupEditRecordPopup sets up all the button clicks to display and hide the popup element
function SetupEditRecordPopup() {
    // Get the popup element
    let popup = document.getElementById("edit-record-popup");
    // Get the buttons that open the popup
    let openBtn = document.getElementsByClassName("dialog-button");
    // Get the button to open the add record popup
    let closeBtn = document.getElementById("close-popup-button");
    // When the user clicks on the button, open the popup
    for (let i = 0; i < openBtn.length; i++) {
        openBtn[i].onclick = function () {
            // display popup
            popup.style.display = "block";

            // get edit record form html element
            let editRecordForm = document.getElementById("edit-record-form");

            // parse and collect the previous values of the record being edited
            let previousValues = [];
            let tableRow = document.getElementById("database-table-body").querySelectorAll("tr")[i];
            for (let dataCell of tableRow.querySelectorAll("td")){
                previousValues.push(dataCell.innerHTML);
            }

            // update global id of record currently being edited
            beingEditedId = previousValues[0];

            UpdateFormWithPreviousValues(editRecordForm, previousValues.slice(1));
        }
    }
    closeBtn.onclick = function () {
        popup.style.display = "none";
    }
}

// SetupAddRecordPopup sets up the button onclicks required for the popup
function SetupAddRecordPopup() {
    // Get the popup element
    let popup = document.getElementById("add-record-popup");
    // Get the buttons that open the popup
    let addRecordBtn = document.getElementById("add-record-button");
    // Get the <button> element that closes the popup
    let closeBtn = document.getElementById("add-close-popup-button");
    // When the user clicks on the button, open the popup
    addRecordBtn.onclick = function () {
        // display popup
        popup.style.display = "block";

    }
    closeBtn.onclick = function () {
        popup.style.display = "none";
    }
}

SetupEditRecordPopup();
SetupAddRecordPopup();
