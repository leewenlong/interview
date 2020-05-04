package priv.netty.demo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;


public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline()
                .addLast(new DelimiterBasedFrameDecoder(1024,Delimiters.lineDelimiter()))
        .addLast(new StringDecoder(CharsetUtil.UTF_8))
        .addLast(new StringEncoder(CharsetUtil.UTF_8))
        .addLast(new ServerHandler());
    }
}
