declare module dcodeIO {
    export class ProtoBuf {
        /*
        * Loads a .proto file and returns the Builder.
        */
        static loadProtoFile(path:string):any;

        /*
        * Loads a .proto string and returns the Builder.
        */
        static loadProto(proto:string, builder?:any, filename?:any):any;
    }
}

declare module dcodeIO.ProtoBuf.Builder {
    export class Message {
        /**
         * Decodes a message from the specified buffer or string.
         * @param buffer ByteBuffer | ArrayBuffer | Buffer | string ,Buffer to decode from
         * @param enc Encoding if buffer is a string: hex, utf8 (not recommended), defaults to base64
         */
        static decode(buffer: any,enc?: string): Message;

        /**
         * Decodes the message from the specified base64 encoded string.
         * @param str String to decode from
         */
        static decode64(str: string): Message;

        /**
         * Decodes a varint32 length-delimited message from the specified buffer or string.
         * @param buffer ByteBuffer | ArrayBuffer | Buffer | string, Buffer to decode from
         * @param enc Encoding if buffer is a string: hex, utf8 (not recommended), defaults to base64
         */
        static decodeDelimited(buffer: any,enc?: string): Message;

        /**
         * Decodes the message from the specified hex encoded string.
         * @param str String to decode from
         */
        static decodeHex(str: string): Message;

        /**
         * Decodes the message from a JSON string.
         * @param str String to decode from
         */
        static decodeJSON(str: string): Message;

        /**
         * Adds a value to a repeated field. This is an alias for ProtoBuf.Builder.Message#add. return this
         * @param key       Field name
         * @param value     Value to add
         * @param noAssert  Whether to assert the value or not (asserts by default)
         */
        add(key: string,value: any,noAssert: boolean): Message;

        /**
         * Gets a field's value. This is an alias for ProtoBuf.Builder.Message#$get.
         * @param key
         */
        get(key: string): any;

        /**
         * Sets a field's value. This is an alias for [@link ProtoBuf.Builder.Message#set}.
         * @param keyOrObj string | !Object.<string, *> ,String key or plain object holding multiple values
         * @param valueopt  * | boolean ,Value to set if key is a string, otherwise omitted
         * @param noAssertopt   ,Whether to not assert the value, defaults to false
         */
        set(keyOrObj: any,valueopt?: any,noAssertopt?: boolean);

        /**
         * Directly encodes the message to an ArrayBuffer.
         */
        encodeAB(): ArrayBuffer;

        /**
         * Returns the message as an ArrayBuffer. This is an alias for ProtoBuf.Builder.Message#encodeAB.
         */
        toArrayBuffer(): ArrayBuffer;
    }
}
