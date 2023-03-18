#define MAX(x, y) (((x) > (y)) ? (x) : (y))
#define MIN(x, y) (((x) < (y)) ? (x) : (y))

typedef struct {
    char* map[5000];
    int pos;
    int len;
} BrowserHistory;

BrowserHistory* browserHistoryCreate(char * homepage) {
    BrowserHistory* obj = malloc(sizeof(*obj));
    obj->map[obj->len = obj->pos = 0] = homepage;
    return obj;
}

void browserHistoryVisit(BrowserHistory* obj, char * url) {
    obj->map[obj->len = ++(obj->pos)] = url;
}

char * browserHistoryBack(BrowserHistory* obj, int steps) {
    return obj->map[obj->pos = MAX(0, (obj->pos - steps))];
}

char * browserHistoryForward(BrowserHistory* obj, int steps) {
    return obj->map[obj->pos = MIN(obj->len, (obj->pos + steps))];
}

void browserHistoryFree(BrowserHistory* obj) {
    free(obj);
}