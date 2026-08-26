# Disable Slime Chunks

Disable Slime Chunks is a server-side Fabric mod that lets players control natural slime spawning in individual chunks using a simple structure made from vanilla blocks.

## How it works

Build the following vertical structure anywhere inside the chunk you want to control, from bottom to top:

1. A note block
2. A slime block directly on top of the note block
3. A lever placed on top of the slime block

Switch the lever on to disable natural slime spawning throughout that chunk. Switch the lever off to immediately allow natural slime spawning again.

The lever must be floor-mounted on top of the slime block. A lever attached to the side of the slime block does not activate the controller.

## Spawn types

The controller blocks naturally spawning slimes, including normal slime-chunk spawning. It does not block slimes created by:

- Commands such as `/summon`
- Spawn eggs
- Dispensers
- Monster spawners

Existing slimes are not removed when a controller is activated.

## Installation

1. Install Fabric Loader for Minecraft 26.2.
2. Install the matching Fabric API version.
3. Place the Disable Slime Chunks JAR in the `mods` folder.
4. Install the mod on the server. For singleplayer, install it in the client instance that hosts the world.

No configuration file is required.

## Requirements

- Minecraft 26.2
- Fabric Loader 0.19.3 or newer
- Fabric API 0.158.0+26.2 or newer for Minecraft 26.2
- Java 25

## License

Disable Slime Chunks is licensed under the GNU Affero General Public License, version 3. See [LICENSE](LICENSE) for the complete license text.
