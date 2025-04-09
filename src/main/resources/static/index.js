function getProducts() {
    return fetch('/api/products')
        .then(r => r.json());
}

function createProductHtml(productData) {
    const template = `
        <h4>${productData.name}</h4>
        <p>${productData.description}</p>
        <p>${productData.price}</p>
        <button data-id="${productData.id}">Add to cart</button>
        <br/>
        <br/>
    `

    const liElement = document.createElement('li');
    liElement.innerHTML = template.trim();

    return liElement;
}

(function() {
    const productList = document.querySelector('.productList');

    getProducts()
        .then(products => products.map(createProductHtml))
        .then(productHtmlElements => productHtmlElements.forEach(el => productList.appendChild(el)));
})();