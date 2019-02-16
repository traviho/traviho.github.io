/**** Dad's side of the family (Ho) ****/

treeDataHo = [{
    "name": "Ho Shui Pong",
    "class": "man",
    "marriages": [{
        "spouse": {
        "name": "Cai Gui",
        "class": "woman",
        },
        "children": [
            {
                "name": "1st Brother",
                "class": "man"
            },
            {
                "name": "2nd Brother",
                "class": "man"
            },
            {
                "name": "3rd Brother",
                "class": "man"
            },
            {
                "name": "1st Sister",
                "class": "woman"
            },
            {
                "name": "2nd Sister",
                "class": "woman"
            },
            {
                "name": "3rd Sister",
                "class": "woman"
            },
            {
                "name": "4th Sister",
                "class": "woman"
            },
            {
                "name": "5th Sister",
                "class": "woman"
            },
            {
                "name": "6th Sister",
                "class": "woman"
            },
            {
                "name": "7th Sister",
                "class": "woman"
            },
            {
                "name": "Sing Ho (1965)",
                "class": "man",
                "marriages": [{
                    "spouse": {
                    "name": "Erica Yang (1962)",
                    "class": "woman"
                    },
                    "children": [
                        {
                            "name": "Travis Ho (1998)",
                            "class": "man",
                        },
                        {
                            "name": "Rebecca Ho (1996)",
                            "class": "woman"
                        }
                    ]
                }]
            }
        ]
    }]
}]

/**** Mom's side of the family (Yang) ****/

treeDataYang = [{
    "name": "Liao Shi Xiang",
    "class": "woman",
    "marriages": [{
        "spouse": {
        "name": "Yang Chin Chung",
        "class": "man",
        },
        "children": [
            {
                "name": "Erica Yang (1962) 3rd Sister",
                "class": "woman",
                "marriages": [{
                    "spouse": {
                    "name": "Sing Ho (1965)",
                    "class": "man"
                    },
                    "children": [
                        {
                            "name": "Rebecca Ho (1996)",
                            "class": "woman"
                        },
                        {
                            "name": "Travis Ho (1998)",
                            "class": "man",
                        }
                    ]
                }]
            },
            {
                "name": "1st Brother",
                "class": "man"
            },
            {
                "name": "2nd Brother",
                "class": "man"
            },
            {
                "name": "3rd Brother",
                "class": "man"
            },
            {
                "name": "4th Brother",
                "class": "man"
            },
            {
                "name": "5th Brother",
                "class": "man"
            },
            {
                "name": "1st Sister",
                "class": "woman"
            },
            {
                "name": "2nd Sister",
                "class": "woman"
            }
        ]
    }]
}]

extras = {
    debug: true,
    height: 800,
    width: 1200,
    callbacks: {
        nodeClick: function(name, extra) {
        console.log(name);
        },
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

dTree.init(treeDataYang, {
    target: "#yang-graph",
    ...extras
});

dTree.init(treeDataHo, {
    target: "#ho-graph",
    ...extras
});
