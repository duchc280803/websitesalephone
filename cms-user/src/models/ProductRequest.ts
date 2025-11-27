export interface IProductRequest {
    productName: string;
    description?: string;
    quantity: number;
    price: number;
    productVariantId?: string;
    productId?: string;
    colorId?: string;
    cameraId?: string;
    batteryId?: string;
    cpuId?: string;
    imageId?: string;
    screenId?: string;
    originId?: string;
    storageId?: string;
    supplierId?: string;
    operatorId?: string;
    ramId?: string;
}

export class ProductRequest {
    public productName: string;
    public description?: string;
    public quantity: number;
    public price: number;
    public productVariantId?: string;
    public productId?: string;
    public colorId?: string;
    public cameraId?: string;
    public batteryId?: string;
    public cpuId?: string;
    public imageId?: string;
    public screenId?: string;
    public originId?: string;
    public storageId?: string;
    public supplierId?: string;
    public operatorId?: string;
    public ramId?: string;

    constructor(data: {
        productName: string;
        description?: string;
        quantity: number;
        price: number;
        productVariantId?: string;
        productId?: string;
        colorId?: string;
        cameraId?: string;
        batteryId?: string;
        cpuId?: string;
        imageId?: string;
        screenId?: string;
        originId?: string;
        storageId?: string;
        supplierId?: string;
        operatorId?: string;
        ramId?: string;
    }) {
        this.productName = data.productName.trim();
        this.description = data.description?.trim();
        this.quantity = data.quantity;
        this.price = data.price;
        this.productVariantId = data.productVariantId?.trim();
        this.productId = data.productId?.trim();
        this.colorId = data.colorId?.trim();
        this.cameraId = data.cameraId?.trim();
        this.batteryId = data.batteryId?.trim();
        this.cpuId = data.cpuId?.trim();
        this.imageId = data.imageId?.trim();
        this.screenId = data.screenId?.trim();
        this.originId = data.originId?.trim();
        this.storageId = data.storageId?.trim();
        this.supplierId = data.supplierId?.trim();
        this.operatorId = data.operatorId?.trim();
        this.ramId = data.ramId?.trim();
    }

    toPayload(): IProductRequest {
        return {
            productName: this.productName,
            description: this.description,
            quantity: this.quantity,
            price: this.price,
            productVariantId: this.productVariantId,
            productId: this.productId,
            colorId: this.colorId,
            cameraId: this.cameraId,
            batteryId: this.batteryId,
            cpuId: this.cpuId,
            imageId: this.imageId,
            screenId: this.screenId,
            originId: this.originId,
            storageId: this.storageId,
            supplierId: this.supplierId,
            operatorId: this.operatorId,
            ramId: this.ramId,
        };
    }
}
