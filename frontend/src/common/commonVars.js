export function getCommonConfigWithToken(token) {
    return {
        headers: {
            'content-type':
                'application/json',
            'Authorization':
                'Bearer ' + token,
        },
        json: true,
    }
}

export function getCommonFilePostConfig() {
    return {
        headers: {
            'content-type':
                'text/csv',
            'Access-Control-Allow-Origin': '*',
        },
    }
}

export function getCommonConfig() {
    return {
        headers: {
            'content-type':
                'application/json',
            'Access-Control-Allow-Origin': '*',
        },
    }
}

export function getCommonConfigWithParams(token, params) {
    return {
        headers: {
            'content-type':
                'application/json',
            'Authorization':
                'Bearer ' + token,
        },
        params: params,
        json: true,
    }
}