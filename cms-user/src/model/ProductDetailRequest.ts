export interface IProductDetailRequest {
    idProduct?: string;
    idProductVariant?: string;
    productImageId?: string;
    inventoryId?: string;
}

export class ProductDetailRequest {
    public idProduct?: string;
    public idProductVariant?: string;
    public productImageId?: string;
    public inventoryId?: string;

    constructor(data: {
        idProduct?: string;
        idProductVariant?: string;
        productImageId?: string;
        inventoryId?: string;
    }) {
        this.idProduct = data.idProduct?.trim();
        this.idProductVariant = data.idProductVariant?.trim();
        this.productImageId = data.productImageId?.trim();
        this.inventoryId = data.inventoryId?.trim();
    }

    // Chuyển sang payload gửi API
    toPayload(): IProductDetailRequest {
        return {
            idProduct: this.idProduct,
            idProductVariant: this.idProductVariant,
            productImageId: this.productImageId,
            inventoryId: this.inventoryId,
        };
    }
}
