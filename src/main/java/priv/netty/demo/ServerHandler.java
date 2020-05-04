package priv.netty.demo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ServerHandler extends SimpleChannelInboundHandler<String> {
    static final ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("received msg:" + msg);
        group.forEach(c -> {
            if (c == ctx.channel()) {
                c.writeAndFlush("<自己>：" + msg + "\n");
            } else {
                c.writeAndFlush(ctx.channel().remoteAddress() + "：" + msg + "\n");
            }
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        group.writeAndFlush(ctx.channel().remoteAddress() + " 上线\n");
        group.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        group.writeAndFlush(ctx.channel().remoteAddress() + " 下线\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " 断开");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " 连接");
    }

//    @Override
//    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
//        group.writeAndFlush(ctx.channel().remoteAddress()+" 上线-\n");
//        group.add(ctx.channel());
//    }
//
//    @Override
//    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
//        group.writeAndFlush(ctx.channel().remoteAddress()+" 下线-\n");
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
