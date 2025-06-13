import { Injectable } from '@nestjs/common';
import { HttpService } from '@nestjs/axios';
import { ConfigService } from '@nestjs/config';
import { firstValueFrom, Observable } from 'rxjs';
import { HttpErrorUtil } from '../utils/http-error.util';
import { AxiosResponse } from 'axios';

@Injectable()
export abstract class BaseApiService {
    protected readonly serviceUrl: string;

    constructor(
        protected readonly httpService: HttpService,
        protected readonly configService: ConfigService,
        private readonly urlConfigKey: string
    ) {
        this.serviceUrl = this.getRequiredConfig(urlConfigKey);
    }

    private getRequiredConfig(key: string): string {
        const value = this.configService.get<string>(key);
        if (!value) {
            throw new Error(`${key} is not defined in environment variables`);
        }
        return value;
    }

    protected async makeRequest<T>(requestObservable: Observable<AxiosResponse<T>>): Promise<T> {
        try {
            const response = await firstValueFrom(requestObservable);
            return response.data;
        } catch (error) {
            HttpErrorUtil.handleApiError(error);
        }
    }
}