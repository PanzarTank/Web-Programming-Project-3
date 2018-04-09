function calculatePrice() {

    //Get selected data
    var table = document.getElementById("cart");
    var cells = table.querySelectorAll("#price, #quantity");
    var subTotals = table.querySelectorAll("#subTotal")

    console.log(subTotals);

    //["0"].attributes[2].value

    var price = 0;
    var quantity = 0;
    var total = 0;
    var subTotals = [];
    var loop = 0;

    for (var i = 0; i < cells.length;) {
        console.log("Price: " + cells[i].attributes[1].value);
        price = cells[i].attributes[1].value;
        console.log("Quantity: " + cells[i + 1].childNodes[1].value);
        quantity = cells[i + 1].childNodes[1].value;
        total = total + (price * quantity);
        subTotals[i] = price * quantity;
        console.log("Subtotal: " + subTotals[i]);
        loop++;
        i = i + 2;
    }


    total = Math.floor(total * 100) / 100;
    total = total.toFixed(2);
    console.log("Total: " + total);
    var t = 1;
    var u = 1;

    //print value to PicExtPrice 
    for (t = 1; t <= loop; t++) {
        document.getElementById("PicExtPrice" + t).value = ("Total: $" + total);
    }

    console.log(document.getElementById("subTotal" + u).textContent);
    subTotals.forEach(element => {
        console.log("Testerino foreach " + element);
        document.getElementById("subTotal" + u).textContent = ("$" + element);
        u++;
    });
}