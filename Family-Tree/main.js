/*
Google Form Input is an array of objects, containing name, data, and children information
*/
const table = {};

function createTreeDataAux(key, visited) {
    const obj = {
        "name": key,
        "class": "man"
    };
    const spouse = table[key].spouse;

    visited.add(key);
    visited.add(spouse);

    if (spouse !== "") {
        const children = [];
        table[key].children.forEach(child => {
            // if (!visited.has(child)) {
                children.push(createTreeDataAux(child, visited));
            // }
        });
        obj["marriages"] = [{
            "spouse": {
                "name": spouse,
                "class": "man",
            },
            "children": children,
        }];
    }
    return obj;
}
function createTreeTable(googleFormArray) {
    googleFormArray.forEach(formObj => {
        table[formObj.name] = {
            "name": formObj["name"],
            "sibling-position": formObj["sibling-position"],
            "era": formObj["era"],
            "birth-location": formObj["birth-location"],
            "image": formObj["image"],
            "description": formObj["description"],
            "children": formObj["children"] === "" ? [] : formObj["children"].split(","),
            "spouse": formObj["spouse"],
        }
        table[formObj.name].children.forEach(child => {
            if (table[child]) {
                table[child].parent = formObj.name;
            }
        });
    });
    console.log(table);
}

function createTreeData() {
    const res = [];
    const visited = new Set();

    for (var key in table) {
        if (table[key].parent === undefined) {
            if (!visited.has(key)){
                res.push(createTreeDataAux(key, visited));
            }
        }
    }
    return res;
}

/* Set up DTree */
// node click, create modal using JQuery
function nodeClick(name, extra) {
    const nameTitle = (table[name]["name"] === "") ? "Name" : table[name]["name"];
    const siblingPosition = table[name]["sibling-position"];
    const profileImage = (table[name]["image"] === "") ? "man-user.png" : table[name]["image"];
    const eraTitle = (table[name]["era"] === "") ? "Time Period" : table[name]["era"];
    const birthLocationTitle = (table[name]["birth-location"] === "") ? "Birth Location" : table[name]["birth-location"];
    const description = (table[name]["description"] === "") ? "Description" : table[name]["description"];
    
    $('#description-modal-title').text(nameTitle);
    $('#description-modal-profile-image').attr("src", profileImage);
    $('#description-modal-era-header').text(eraTitle);
    $('#description-modal-birth-location-header').text(birthLocationTitle);
    $('#description-modal-description').text(description);
    
    $('#description-modal').modal('show');
}

extras = {
    debug: true,
    height: $(window).height(),
    width: $(window).width(),
    callbacks: {
        nodeClick: nodeClick,
        textRenderer: function(name, extra, textClass) {
            // THis callback is optinal but can be used to customize
        // how the text is rendered without having to rewrite the entire node
        // from screatch.
            if (extra && extra.nickname)
            name = name + " (" + extra.nickname + ")";
            return "<p align='center' class='" + textClass + "'>" + name + "</p>";
        },
        nodeRenderer: function(name, x, y, height, width, extra, id, nodeClass, textClass, textRenderer) {
        // This callback is optional but can be used to customize the
        // node element using HTML.
        let node = '';
        node += '<div ';
        node += 'style="height:100%;width:100%;" ';
        node += 'class="' + nodeClass + '" ';
        node += 'id="node' + id + '">\n';
        node += textRenderer(name, extra, textClass);
        node += '</div>';
        return node;
        }
    }
}

// Set up google form, and load DTree after loaded.
var yangSpreadsheetUrl = 'https://docs.google.com/spreadsheets/d/1Z9TJKi2Ud8jQmxWpdDlbaNzDR2tRquWi3BQcExUSOCE/pubhtml';
function init() {
    Tabletop.init({
        key: yangSpreadsheetUrl,
        callback: function(data, tabletop) { 
            console.log(data);
            createTreeTable(data);
            const treeData = createTreeData();
            console.log(treeData);
            dTree.init(treeData, {
                target: "#yang-graph",
                ...extras
            });
        },
        simpleSheet: true
    });
}
window.addEventListener("DOMContentLoaded", init);
