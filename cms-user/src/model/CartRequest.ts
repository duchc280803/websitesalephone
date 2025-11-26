export interface ICartRequest {
    productId: string;
    quantity: number;
}

export class CartRequest {
    public productId: string;
    public quantity: number;

    constructor(productId: string, quantity: number) {
        this.productId = productId.trim();
        this.quantity = quantity;
    }

    // Chuyển sang payload gửi API
    toPayload(): ICartRequest {
        return {
            productId: this.productId,
            quantity: this.quantity,
        };
    }
}
