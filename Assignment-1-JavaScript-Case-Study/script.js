function validateCustomer() {

    var custId = document.getElementById("custID").value;

    var validateCust = custId.includes("XYZ");

    if (validateCust) {
        document.getElementById("result").innerHTML =
            "Customer ID is valid, you can proceed further to generate coupon.";
    }
    else {
        document.getElementById("result").innerHTML =
            "You are not a valid customer.";
    }

}

function generateCoupon() {

    var custId = document.getElementById("custID").value;

    var validateCust = custId.includes("XYZ");

    if (validateCust) {

        var coupon = custId + "789456";

        document.getElementById("result").innerHTML =
            "Your coupon is: " + coupon;

    }
    else {

        document.getElementById("result").innerHTML =
            "Invalid customer ID. Coupon can't be generated.";

    }

}