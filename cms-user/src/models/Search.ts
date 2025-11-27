export interface IPagingRequest {
    page: number;
    size: number;
}

export class PagingRequest {
    public page: number;
    public size: number;

    constructor(page: number = 1, size: number = 10) {
        this.page = page;
        this.size = size;
    }

    toPayload(): IPagingRequest {
        return {
            page: this.page,
            size: this.size,
        };
    }
}

export interface IOrderSearch extends IPagingRequest {
    searchText?: string;
}

export class Search extends PagingRequest {
    public searchText?: string;

    constructor(page: number = 1, size: number = 10, searchText?: string) {
        super(page, size);
        this.searchText = searchText?.trim();
    }

    toPayload(): IOrderSearch {
        return {
            ...super.toPayload(),
            searchText: this.searchText,
        };
    }
}
