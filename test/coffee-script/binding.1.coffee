$('.shopping_cart').bind 'click', (event) =>
    @customer.purchase @cart
