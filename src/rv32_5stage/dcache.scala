package object AcaCustom
{
	import Chisel._
	import Node._
	import Sodor.Constants._
	import Common._

	class DCacheInterface()(implicit conf: SodorConfiguration) extends Module
	{
		val io = new Bundle {
			val core_port = (new MemPortIo(data_width=conf.xprlen)).flip
			val mem_port = new MemPortIo(data_width=conf.xprlen)
		}
	}

	class NoDCache()(implicit conf: SodorConfiguration) extends DCacheInterface
	{
		io.mem_port <> io.core_port
	}

	type DCache = NoDCache
}
