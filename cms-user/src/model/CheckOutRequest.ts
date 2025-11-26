export interface ICheckOutRequest {
    recipientName: string;
    phone: string;
    addressLine: string;
    city: string;
    district: string;
    postalCode: string;
}

export class CheckOutRequest {
    public recipientName: string;
    public phone: string;
    public addressLine: string;
    public city: string;
    public district: string;
    public postalCode: string;

    constructor(
        recipientName: string,
        phone: string,
        addressLine: string,
        city: string,
        district: string,
        postalCode: string
    ) {
        this.recipientName = recipientName.trim();
        this.phone = phone.trim();
        this.addressLine = addressLine.trim();
        this.city = city.trim();
        this.district = district.trim();
        this.postalCode = postalCode.trim();
    }

    // Chuyển sang payload gửi API
    toPayload(): ICheckOutRequest {
        return {
            recipientName: this.recipientName,
            phone: this.phone,
            addressLine: this.addressLine,
            city: this.city,
            district: this.district,
            postalCode: this.postalCode,
        };
    }
}
