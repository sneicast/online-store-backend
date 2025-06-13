import {  Injectable } from '@nestjs/common';
import { HttpService } from '@nestjs/axios';

import { ConfigService } from '@nestjs/config';

import { BaseApiService } from 'src/common/services/base-api.service';

@Injectable()
export class AuthService extends BaseApiService {
    constructor(httpService: HttpService, configService: ConfigService) {
        super(httpService, configService, 'AUTH_SERVICE_URL');
    }

    async loginAdmin(credentials: { username: string; password: string }) {
        const request$ = this.httpService.post(
            `${this.serviceUrl}/api/admin/auth/login`,
            credentials,
            {
                headers: { 'Content-Type': 'application/json' },
            }
        );

        return this.makeRequest(request$);
    }
    async loginCustomer(credentials: { username: string; password: string }) {
        const request$ = this.httpService.post(
            `${this.serviceUrl}/api/customer/auth/login`,
            credentials,
            {
                headers: { 'Content-Type': 'application/json' },
            }
        );

        return this.makeRequest(request$);
    }
    
}
