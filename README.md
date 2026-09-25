# 💚 Disable Slime Chunks

[![GitHub Release](https://img.shields.io/github/v/release/SwordfishBE/DisableSlimeChunks?display_name=release&logo=github)](https://github.com/SwordfishBE/DisableSlimeChunks/releases)
[![GitHub Downloads](https://img.shields.io/github/downloads/SwordfishBE/DisableSlimeChunks/total?logo=github)](https://github.com/SwordfishBE/DisableSlimeChunks/releases)
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/HlXmjZ8H?logo=modrinth&logoColor=white&label=Modrinth%20downloads)](https://modrinth.com/mod/disableslimechunks)
[![CurseForge Downloads](https://img.shields.io/curseforge/dt/1711105?logo=curseforge&logoColor=white&label=CurseForge%20downloads)](https://www.curseforge.com/minecraft/mc-mods/disable-slime-chunks/)

A slime chunk in the middle of your build? Stop covering every floor with carpet or string just to keep those pesky green visitors away. Place a note block, a slime block, and a powered lever to disable natural slime spawning in that chunk. Flip the lever off whenever you want the slimes back.

Disable Slime Chunks is a server-side Fabric mod (also works in single player) that lets players control natural slime spawning in individual chunks using a simple structure made from vanilla blocks.

---

## ⁉️ How it works

Build the following vertical structure anywhere inside the chunk you want to control, from bottom to top:

1. A note block
2. A slime block directly on top of the note block
3. A lever placed on top of the slime block

Switch the lever on to disable natural slime spawning throughout that chunk. Switch the lever off to immediately allow natural slime spawning again.

The lever must be floor-mounted on top of the slime block. A lever attached to the side of the slime block does not activate the controller.

---

## ✅ Spawn types

The controller blocks naturally spawning slimes, including normal slime-chunk spawning. It does not block slimes created by:

- Commands such as `/summon`
- Spawn eggs
- Dispensers
- Monster spawners

Existing slimes are not removed when a controller is activated.

No configuration file is required.

---

## 📦 Installation

| Platform   | Link |
|------------|------|
| GitHub     | [Releases](https://github.com/SwordfishBE/DisableSlimeChunks/releases) |
| Modrinth | [DisableSlimeChunks](https://modrinth.com/mod/disableslimechunks) |
| CurseForge | [DisableSlimeChunks](https://www.curseforge.com/minecraft/mc-mods/disable-slime-chunks) |


1. Download the latest JAR from your preferred platform above.
2. Place the JAR in your server's `mods/` folder.
3. Make sure [Fabric API](https://modrinth.com/mod/fabric-api) is also installed.
4. Start Minecraft — the config file will be created automatically.

---

## 🧱 Building from Source

```bash
git clone https://github.com/SwordfishBE/DisableSlimeChunks.git
cd DisableSlimeChunks
chmod +x gradlew
./gradlew build
```

The remapped mod jar is written to `build/libs/`.

---

## 📄 License

Disable Slime Chunks is licensed under the GNU Affero General Public License, version 3. See [LICENSE](LICENSE) for the complete license text.
