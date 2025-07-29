#!/usr/bin/env sh

if [ -z "$GRADLE_HOME" ]; then
  gradle_cmd=gradle
else
  gradle_cmd="$GRADLE_HOME/bin/gradle"
fi

exec "$gradle_cmd" "$@"
